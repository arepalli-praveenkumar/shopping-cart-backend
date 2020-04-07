/**
 * 
 */
package com.shoppingCartBe.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author praveen
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/demo")
public class SpringDemoController {
	
	@GetMapping("/first-step")
	public ResponseEntity<String> getResponse() {
		return ResponseEntity.ok("I love you Kasi");
	}

}
