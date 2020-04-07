/**
 * 
 */
package com.shoppingCartBe.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author praveen
 *
 */
@Document(collection = "products")
public class Product {
	
	@Id
	private ObjectId _id;
	private String name;
	private String imgUrl;
	private int price;
	private String currency;
	private String make;
	private String brand;
	private String remarks;
	private long productID;
	private long itemTotalPrice;
	private long quantity;
	
	@Transient
    public static final String SEQUENCE_NAME = "productId";
	
	
		
	public Product() {}
	

	/**
	 * @param _id
	 * @param name
	 * @param imgUrl
	 * @param price
	 * @param currency
	 * @param make
	 * @param brand
	 * @param remarks
	 * @param productID
	 * @param itemTotalPrice
	 * @param quantity
	 */
	public Product(ObjectId _id, String name, String imgUrl, int price, String currency, String make, String brand,
			String remarks, long productID, long itemTotalPrice, long quantity) {
		super();
		this._id = _id;
		this.name = name;
		this.imgUrl = imgUrl;
		this.price = price;
		this.currency = currency;
		this.make = make;
		this.brand = brand;
		this.remarks = remarks;
		this.productID = productID;
		this.itemTotalPrice = itemTotalPrice;
		this.quantity = quantity;
	}



	/**
	 * @return the itemTotalPrice
	 */
	public long getItemTotalPrice() {
		return itemTotalPrice;
	}



	/**
	 * @param itemTotalPrice the itemTotalPrice to set
	 */
	public void setItemTotalPrice(long itemTotalPrice) {
		this.itemTotalPrice = itemTotalPrice;
	}



	/**
	 * @return the quantity
	 */
	public long getQuantity() {
		return quantity;
	}



	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}



	/**
	 * @return the _id
	 */
	public ObjectId get_id() {
		return _id;
	}



	/**
	 * @param _id the _id to set
	 */
	public void set_id(ObjectId _id) {
		this._id = _id;
	}



		/**
		 * @return the sequenceName
		 */
		public static String getSequenceName() {
			return SEQUENCE_NAME;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the imgUrl
		 */
		public String getImgUrl() {
			return imgUrl;
		}

		/**
		 * @param imgUrl the imgUrl to set
		 */
		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
		}

		/**
		 * @return the price
		 */
		public int getPrice() {
			return price;
		}

		/**
		 * @param price the price to set
		 */
		public void setPrice(int price) {
			this.price = price;
		}

		/**
		 * @return the currency
		 */
		public String getCurrency() {
			return currency;
		}

		/**
		 * @param currency the currency to set
		 */
		public void setCurrency(String currency) {
			this.currency = currency;
		}

		/**
		 * @return the make
		 */
		public String getMake() {
			return make;
		}

		/**
		 * @param make the make to set
		 */
		public void setMake(String make) {
			this.make = make;
		}

		/**
		 * @return the brand
		 */
		public String getBrand() {
			return brand;
		}

		/**
		 * @param brand the brand to set
		 */
		public void setBrand(String brand) {
			this.brand = brand;
		}

		/**
		 * @return the remarks
		 */
		public String getRemarks() {
			return remarks;
		}

		/**
		 * @param remarks the remarks to set
		 */
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		/**
		 * @return the productID
		 */
		public long getProductID() {
			return productID;
		}

		/**
		 * @param productID the productID to set
		 */
		public void setProductID(long productID) {
			this.productID = productID;
		}

	
	
	

		
}
