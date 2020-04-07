/**
 * 
 */
package com.shoppingCartBe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingCartBe.models.User;

/**
 * @author praveen
 *
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

	Optional<User> findById(Long id);
}
