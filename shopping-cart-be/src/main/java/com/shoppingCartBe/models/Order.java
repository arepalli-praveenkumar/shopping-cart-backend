/**
 * 
 */
package com.shoppingCartBe.models;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author praveen
 *
 */
@Document(collection = "orders")
public class Order {
	
	@Id
	private BigInteger id;
	private Long orderId;
	private Long userID;
	private List<Product> products;
	private Date purchaseDate;
	private Long grandTotal;
	private Long totalQnty;
	
	@Transient
    public static final String SEQUENCE_NAME = "orderId";
	
	public Order() {}
	
	

	/**
	 * @param id
	 * @param orderId
	 * @param userID
	 * @param products
	 * @param purchaseDate
	 * @param grandTotal
	 * @param totalQnty
	 */
	public Order(BigInteger id, Long orderId, Long userID, List<Product> products, Date purchaseDate, Long grandTotal,
			Long totalQnty) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.userID = userID;
		this.products = products;
		this.purchaseDate = purchaseDate;
		this.grandTotal = grandTotal;
		this.totalQnty = totalQnty;
	}



	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the userID
	 */
	public Long getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Long userID) {
		this.userID = userID;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * @return the purchaseDate
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * @param purchaseDate the purchaseDate to set
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * @return the grandTotal
	 */
	public Long getGrandTotal() {
		return grandTotal;
	}

	/**
	 * @param grandTotal the grandTotal to set
	 */
	public void setGrandTotal(Long grandTotal) {
		this.grandTotal = grandTotal;
	}

	/**
	 * @return the totalQnty
	 */
	public Long getTotalQnty() {
		return totalQnty;
	}

	/**
	 * @param totalQnty the totalQnty to set
	 */
	public void setTotalQnty(Long totalQnty) {
		this.totalQnty = totalQnty;
	}

	
}
