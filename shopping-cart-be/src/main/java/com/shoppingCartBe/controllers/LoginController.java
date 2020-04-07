/**
 * 
 */
package com.shoppingCartBe.controllers;

import static org.springframework.data.mongodb.core.query.Criteria.where;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingCartBe.models.User;
import com.shoppingCartBe.services.NextSequenceNumber;
import com.shoppingCartBe.util.PasswordUtils;

/**
 * @author praveen
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private NextSequenceNumber nextSequenceNumber;
	
	private MongoTemplate mongoTemplate;
	
	
	public LoginController(MongoTemplate mongoTemplate ) {
		this.mongoTemplate = mongoTemplate;
	}

	@PostMapping("/signUpUser")
	public String signUpUser(@RequestBody User user) {
		System.out.println("***"+user.getEmail());
		user.setUserID(nextSequenceNumber.getNextSequence(User.SEQUENCE_NAME));
		
		String salt = PasswordUtils.getSalt(30);
		String mySecurePassword = PasswordUtils.generateSecurePassword(user.getPassword(), salt);
		user.setPassword(mySecurePassword);
		user.setSalt(salt);
		// return productsRepository.inserst(product);
		this.mongoTemplate.insert(user);
		return "REG_SUCC";
	}
	
	
	
	@PostMapping("/login")
	public User authenticateUser(@RequestBody User user) {
		User existingUser = this.mongoTemplate.findOne(new Query(where("emailID").is(user.getEmail())), User.class);
		
		boolean passwordMatch = PasswordUtils.verifyUserPassword(user.getPassword(), existingUser.getPassword(), existingUser.getSalt());
		
		JSONObject responJsonObject = new JSONObject();
		
		ResponseEntity.ok(responJsonObject);
		
		if (passwordMatch) {
			//responJsonObject.put("user", existingUser);
			//responJsonObject.put("isSuccess", true);
			//return responJsonObject;
			return existingUser;
			
		} else {
			//responJsonObject.put("user", existingUser);
			//responJsonObject.put("isSuccess", false);
			//return responJsonObject;
			return null;
		}
		
	}
}
