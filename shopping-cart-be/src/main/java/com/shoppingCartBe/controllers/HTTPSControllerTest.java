/**
 * 
 */
package com.shoppingCartBe.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author praveen
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HTTPSControllerTest {
	
	@GetMapping(value = "/ssl-test")
    public String greeting(){
		System.out.println("Im secure service^^^^^^^");
        return "Self Signed SSL is Working!!";
    }

}
