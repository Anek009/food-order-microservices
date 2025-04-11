package com.example.food_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FoodEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodEurekaApplication.class, args);
	}

}
