package com.yoga.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yoga.models.Yoga;
import com.yoga.services.YogaService;

@Controller
public class YogaController {

	@Autowired
	private YogaService yogaService;
	
	@RequestMapping("/yoga/new")
	public String addNewYoga(Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("loggedInUserID");
		if(id == null) {
			return "redirect:/";
		}
		model.addAttribute("yoga", new Yoga());
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		return "addYoga.jsp";
	}
	
	@PostMapping("/yoga/create")
	public String createNewYoga(@Valid @ModelAttribute("yoga") Yoga yoga, BindingResult result, HttpSession session) {
		Long id = (Long) session.getAttribute("loggedInUserID");
		if(id == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "addYoga.jsp";
		}
		this.yogaService.createNewYoga(yoga);
		return "redirect:/home";
	}
	
	@RequestMapping("/yoga/details/{id}")
	public String getYogaDetails(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long idSession = (Long) session.getAttribute("loggedInUserID");
		if(idSession == null) {
			return "redirect:/";
		}
		Yoga yogaDetail = this.yogaService.getOneYoga(id);
		model.addAttribute("yogaDetail", yogaDetail);
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		return "yogaDetail.jsp";
	}
	
	@RequestMapping("/yoga/edit/{id}")
	public String editYoga(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long idSession = (Long) session.getAttribute("loggedInUserID");
		if(idSession == null) {
			return "redirect:/";
		}
		Yoga yoga = this.yogaService.getOneYoga(id);
		model.addAttribute("yoga", yoga);
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		if(idOfLoggedInUser == yoga.getUploader().getId()) {
			return "editYoga.jsp";
		}else {
			return "redirect:/home";
		}
	}
	
	@PutMapping("/yoga/update/{id}")
	public String updateYoga(@PathVariable("id") Long id, @Valid @ModelAttribute("yoga") Yoga yoga, BindingResult result, Model model, HttpSession session) {
		Long idSession = (Long) session.getAttribute("loggedInUserID");
		if(idSession == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
			model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
			return "editYoga.jsp";
		}
		this.yogaService.updateYoga(yoga);
		return "redirect:/home";
	}
	
	@RequestMapping("/yoga/delete/{id}")
	public String deleteYoga(@PathVariable("id") Long id, HttpSession session) {
		Long idSession = (Long) session.getAttribute("loggedInUserID");
		if(idSession == null) {
			return "redirect:/";
		}
		this.yogaService.deleteYoga(id);
		return "redirect:/home";
	}
}
