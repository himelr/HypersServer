package com.example.demo.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoodConfig {
	
	@Bean
	public Food food() {
		return new Food();
	}

}
