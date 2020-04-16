/**
 * 
 */
package com.shoppingCartBe.controllers;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingCartBe.models.CustomSequences;
import com.shoppingCartBe.models.Order;
import com.shoppingCartBe.models.Product;
import com.shoppingCartBe.repositories.ProductsRepository;
import com.shoppingCartBe.security.CurrentUser;
import com.shoppingCartBe.security.UserPrincipal;
import com.shoppingCartBe.services.NextSequenceNumber;

/**
 * @author praveen
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/products")
public class ProductsController {
	
	@Autowired
	 private ProductsRepository productsRepository;
	
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private MongoOperations mongo;
	
	
	@Autowired
	private NextSequenceNumber nextSequenceNumber;

	public ProductsController(MongoTemplate mongoTemplate ) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@RequestMapping("/getAllProducts")
	public List<Product> getAllProducts(@CurrentUser UserPrincipal currentUser) {
		//return productsRepository.findAll();
		return this.mongoTemplate.findAll(Product.class, "products");
	}
	
	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product) {
		product.setProductID(nextSequenceNumber.getNextSequence(Product.SEQUENCE_NAME));
		//productsRepository.inserst(product);
		return this.mongoTemplate.insert(product);
	}
	
	@PostMapping("/updateProductInfo")
	public Product updateProductInfo(@RequestBody Product product) {
		
//		Product updatedProduct = mongo.findAndModify(query(where("productID").is(product.getProductID())),
//      	      new Update().inc("seqenceNumber",1), options().returnNew(true).upsert(true),
//      	    Product.class);
		//Query query = Query.query(Criteria.where("productID", product.getProductID()));
		
		//Product existingProduct = this.mongoTemplate.findOne(Query.query(Criteria.where("productID").is(Long.toString(product.getProductID()))), Product.class);
		Product existingProduct = this.mongoTemplate.findOne(new Query(where("productID").is(product.getProductID())), Product.class);
		System.out.println("existingProduct:::"+existingProduct);
		existingProduct.setBrand(product.getBrand());
		existingProduct.setMake(product.getMake());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setCurrency(product.getCurrency());
		
		// this line try to insert same again. Not advised to update
		//return this.mongoTemplate.insert(existingProduct);
		
		return productsRepository.save(existingProduct);
	}
	
	@GetMapping("/getById/{productId}")
	public List<Product> getProductById(@PathVariable String productId) {
		System.out.println("^^^^^"+productId);
		Query query = new Query();
		query.addCriteria(Criteria.where("productID").is(productId));
		BasicQuery basicQuery = new BasicQuery("{'productID':"+ Integer.parseInt(productId)+ "}");
		System.out.println("string query" + query.toString());
		return this.mongoTemplate.find( basicQuery, Product.class, "products");
	}
	
	@PostMapping("/orderItems")
	public Order purchaseItems(@RequestBody Order order) {
		
		System.out.println("size::"+order.getProducts().size());
		order.setOrderId(nextSequenceNumber.getNextSequence(Order.SEQUENCE_NAME));
		order.setPurchaseDate(new Date());
		order.setProducts(order.getProducts());
		return this.mongoTemplate.insert(order);
		
	}
	
	@GetMapping("/myOrders/{userID}")
	public Collection<Order> getCustomerOrders(@PathVariable Long userID) {
		System.out.println("ProductsController:getCustomerOrders:"+userID);
//		Query query = new Query();
//		query.addCriteria(Criteria.where("userID").is(userID));
		BasicQuery basicQuery = new BasicQuery("{'userID':"+ userID+ "}");
		return this.mongoTemplate.find( basicQuery, Order.class, "orders");
	}


}
