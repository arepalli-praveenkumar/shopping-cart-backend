/**
 * 
 */
package com.shoppingCartBe.controllers;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingCartBe.exception.ResourceNotFoundException;
import com.shoppingCartBe.models.User;
import com.shoppingCartBe.repositories.UserRepository;
import com.shoppingCartBe.security.CurrentUser;
import com.shoppingCartBe.security.UserPrincipal;

/**
 * @author praveen
 *
 */
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
    UserRepository userRepository;
	
	private MongoTemplate mongoTemplate;
	
	
	public UserController(MongoTemplate mongoTemplate ) {
		this.mongoTemplate = mongoTemplate;
	}
	
//	@GetMapping("/users/me")
//    @PreAuthorize("hasRole('USER')")
//    public User getCurrentUser(@CurrentUser UserPrincipal currentUser) {
//		User userSummary = new User(currentUser.getUsername(), currentUser.getName());
//        return userSummary;
//    }
//	
	@GetMapping("/{username}")
    public User getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
       // UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt(), pollCount, voteCount);

        return user;
    }
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		
		User existingUser = this.mongoTemplate.findOne(new Query(where("userID").is(user.getUserID())), User.class);
		
		if (null != existingUser) {
			existingUser.setName(user.getName());
			existingUser.setPhoneNo(user.getPhoneNo());
			existingUser.setGender(user.getGender());
			return mongoTemplate.save(existingUser);
		} else {
			return null;
		}	
	}
	
	@PostMapping("/uploadProfilePic") 
	public User uploadProfilePic(@RequestBody User user) {
		
		User existingUser = this.mongoTemplate.findOne(new Query(where("userID").is(user.getUserID())), User.class);
		
		if (null != existingUser) {
			existingUser.setProfilePicImgStr(user.getProfilePicImgStr());
			return mongoTemplate.save(existingUser);
		} else {
			return null;
		}
		
	}

}
