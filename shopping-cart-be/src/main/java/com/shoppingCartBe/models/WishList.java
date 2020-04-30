/**
 * 
 */
package com.shoppingCartBe.models;

import java.math.BigInteger;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author praveen
 *
 */
@Document(collection = "wishlist")
public class WishList {
	@Id
	private BigInteger id;
	private Long wishId;
	private Long userID;
	private Product product;
	
	@Transient
    public static final String SEQUENCE_NAME = "wishID";
	
	
	/**
	 * @param id
	 * @param wishId
	 * @param userID
	 * @param product
	 */
	public WishList(BigInteger id, Long wishId, Long userID, Product product) {
		super();
		this.id = id;
		this.wishId = wishId;
		this.userID = userID;
		this.product = product;
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
	 * @return the wishId
	 */
	public Long getWishId() {
		return wishId;
	}
	/**
	 * @param wishId the wishId to set
	 */
	public void setWishId(Long wishId) {
		this.wishId = wishId;
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
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	

}
