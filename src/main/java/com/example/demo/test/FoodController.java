package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
	private FoodRepository foodR;
	
	@Autowired
	public FoodController(FoodRepository foodRepository) {
		this.foodR = foodRepository;
		// TODO Auto-generated constructor stub
	}
	
	  @GetMapping("/addFood")
	    public String addFood(@RequestParam String name) {
		  	 Food s = foodR.save(new Food(name));
		  	 
		  	return "Added" + s.getId();
	    }
		

}
