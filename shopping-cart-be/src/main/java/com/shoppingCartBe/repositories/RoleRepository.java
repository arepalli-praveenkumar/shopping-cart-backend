/**
 * 
 */
package com.shoppingCartBe.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingCartBe.models.Role;
import com.shoppingCartBe.models.RoleName;
/**
 * @author praveen
 *
 */
@Repository
public interface RoleRepository extends MongoRepository<Role, String>{
    Optional<Role> findByName(RoleName roleName);
}
