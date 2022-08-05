package com.daikichi.project.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {
	@RequestMapping("/daikichi")
	public String homePage() {
		return "<h1> This will load the home page soon! </h1>";
	}
	
	@RequestMapping("daikichi/travel/{city}")
	public String travelPage(@PathVariable("city") String city) {
		System.out.println("Congratulations! You will soon travel to " + city);
		return "Congratulations! You will soon travel to " + city;
	}
	
	@RequestMapping("daikichi/lotto/{num}")
	public String lotto(@PathVariable("num") int num) {
		if (num %2 == 0) {
			System.out.println("You will take a grand journy in the near future, but be wary of tempting offers");
			return "You will take a grand journy in the near future, but be wary of tempting offers";
		}
		else if (num %2 != 0) {
			System.out.println("You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.");
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
		return "route works";
	}
}


