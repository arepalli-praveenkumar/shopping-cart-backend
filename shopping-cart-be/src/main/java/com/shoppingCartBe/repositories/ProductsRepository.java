/**
 * 
 */
package com.shoppingCartBe.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.shoppingCartBe.models.Order;
import com.shoppingCartBe.models.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author praveen
 *
 */
@Repository
public interface ProductsRepository extends MongoRepository<Product, String> {

	List<Product> findAll();

	void save(Order order);

	//Product findById(long productID);
	
	//void inserst(Product product);
	
	//List<Product> save();
}
