package com.shoppingCartBe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//@AutoConfigureBefore(SecurityAutoConfiguration.class)
public class ShoppingCartBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartBeApplication.class, args);
	}

}
