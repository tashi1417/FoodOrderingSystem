package com.foodorder.foodorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.foodorder.foodorder.entity")
public class FoodorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodorderApplication.class, args);
		System.out.println("App is working");
	}

}
