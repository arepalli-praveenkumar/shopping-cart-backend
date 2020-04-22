/**
 * 
 */
package com.shoppingCartBe.models;


import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author praveen
 *
 */
@Document(collection = "users")
public class User {

	
	//private ObjectId _id;
	@Id
	private BigInteger id;
	private String name;
	private String email ;
	private String username;
	private String phoneNo;
	private String password;
	private long userID;
	private String salt;
	private String profilePicImgStr;
	private String gender;
	private Set<Role> roles = new HashSet<>();
	
	
	@Transient
    public static final String SEQUENCE_NAME = "userID";
	
	public User(String username, String name) {
		//this.id = id;
		this.username = username;
		this.name = name;
		
	}
	
	public User() {};
	
	
	/**
	 * @param _id
	 * @param name
	 * @param emailID
	 * @param phoneNo
	 * @param password
	 * @param userID
	 * @param role
	 */
	public User(ObjectId _id, String name, String email, String phoneNo, String password, long userID,
			Set<Role> roles, String salt) {
		super();
		//this._id = _id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
		this.userID = userID;
		this.roles = roles;
		this.salt = salt;
	}
	
	public User(String name, String userName,String email, String password, String username) {
		this.name = name;
		this.email = email;
		this.password =password;
		this.username = username;
	}
//	/**
//	 * @return the _id
//	 */
//	public ObjectId get_id() {
//		return _id;
//	}
//	/**
//	 * @param _id the _id to set
//	 */
//	public void set_id(ObjectId _id) {
//		this._id = _id;
//	}
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
	 * @return the emailID
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param emailID the emailID to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the userID
	 */
	public long getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}

		/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the userName
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the profilePicImgStr
	 */
	public String getProfilePicImgStr() {
		return profilePicImgStr;
	}

	/**
	 * @param profilePicImgStr the profilePicImgStr to set
	 */
	public void setProfilePicImgStr(String profilePicImgStr) {
		this.profilePicImgStr = profilePicImgStr;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
