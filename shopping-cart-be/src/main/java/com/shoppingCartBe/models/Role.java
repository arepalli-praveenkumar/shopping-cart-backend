/**
 * 
 */
package com.shoppingCartBe.models;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author praveen
 *
 */
@Document(collection = "roles")
public class Role {
	
    
    @Id
    private BigInteger id;
    private RoleName name;

    
    public Role() {

    }

    public Role(RoleName name) {
        this.name = name;
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
	 * @return the name
	 */
	public RoleName getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(RoleName name) {
		this.name = name;
	}
		

}
