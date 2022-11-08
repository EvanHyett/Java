package com.yoga.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yoga.models.LoginUser;
import com.yoga.models.User;
import com.yoga.models.Yoga;
import com.yoga.services.UserService;
import com.yoga.services.YogaService;

@Controller
public class HomeController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private YogaService yogaServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		User user = this.userServ.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("loggedInUserID", user.getId());
		return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userServ.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("loggedInUserID", user.getId());
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("loggedInUserID");
		if(id == null) {
			return "redirect:/";
		}
		User loggedInUser = this.userServ.findOneUser(id);
		model.addAttribute("loggedInUser", loggedInUser);
		List<Yoga> allYoga = this.yogaServ.findAllYogas();
		model.addAttribute("allYoga", allYoga);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}