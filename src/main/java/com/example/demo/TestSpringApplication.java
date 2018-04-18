/*
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.test.Food;
import com.example.demo.test.FoodConfig;

@SpringBootApplication
public class TestSpringApplication {
	private final String test = "d";
	
	public static void main(String[] args) {
	      ApplicationContext ctx = new AnnotationConfigApplicationContext(FoodConfig.class);
	      Food food = ctx.getBean(Food.class);
	      food.setName("Chicken");
	      
		SpringApplication.run(TestSpringApplication.class, args);
	}
}
*/
