package com.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/results", method=RequestMethod.POST)
	public String results(HttpSession session,
			@RequestParam(value="number") Integer number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="livingThing") String livingThing,
			@RequestParam(value="description") String description) {
		
		Integer num = (Integer) session.getAttribute(null);
		session.setAttribute("num", number);
		
		String cityName = (String) session.getAttribute(city);
		session.setAttribute("cityName", city);
		
		String personName = (String) session.getAttribute(person);
		session.setAttribute("personName", person);
		
		String hobbyName = (String) session.getAttribute(hobby);
		session.setAttribute("hobbyName", hobby);
		
		String livingThingName = (String) session.getAttribute(livingThing);
		session.setAttribute("livingThingName", livingThing);
		
		String descriptionName = (String) session.getAttribute(description);
		session.setAttribute("descriptionName", description);
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "results.jsp";
	}
}
