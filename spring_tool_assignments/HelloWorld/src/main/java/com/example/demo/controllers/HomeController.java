package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/home")
	public String homePage() {
		return "<h1> This will load the home page soon! </h1>";
	}
	
	@RequestMapping("/home/user")
	public String userPage(@RequestParam(value = "firstName") String firstName, 
							@RequestParam(value = "lastName", required = false) String lastName) {
		System.out.println("Hey there " + firstName + " " + lastName);
		return "Hey there " + firstName + " " + lastName;
	}
	
	@RequestMapping("home/user/{firstName}/{lastName}")
	public String userPagePathVariable(@PathVariable("firstName") String firstName,
										@PathVariable("lastName") String lastName) {
		System.out.println("Hey there " + firstName + " " + lastName);
		return "Hey there " + firstName + " " + lastName;
	}
}
