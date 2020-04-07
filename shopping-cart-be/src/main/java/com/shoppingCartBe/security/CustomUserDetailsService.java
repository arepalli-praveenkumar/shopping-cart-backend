/**
 * 
 */
package com.shoppingCartBe.security;


import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingCartBe.models.Product;
import com.shoppingCartBe.models.User;
import com.shoppingCartBe.repositories.UserRepository;

/**
 * @author praveen
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
    UserRepository userRepository;
	
	private MongoTemplate mongoTemplate;
	
	public CustomUserDetailsService(MongoTemplate mongoTemplate ) {
		this.mongoTemplate = mongoTemplate;
	}
	

	@Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> 
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
        );

        return UserPrincipal.create(user);
    }
	
	// This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
    	 User user1 = this.mongoTemplate.findOne(new Query(where("userID").is(id)), User.class);
    	 
    	 if (null != user1) {
    		 new UsernameNotFoundException("User not found with id : " + id);
    	 } else {
    		 UserPrincipal.create(user1);
    	 }
//        User user = userRepository.findById(id).orElseThrow(
//            () -> new UsernameNotFoundException("User not found with id : " + id)
//        );

        return UserPrincipal.create(user1);
    }

}
