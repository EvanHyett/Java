package com.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dojosninjas.models.Dojo;
import com.dojosninjas.models.Ninja;
import com.dojosninjas.services.AppService;

@Controller
public class HomeController {
	private final AppService appServ;
	
	public HomeController(AppService appServ) {
		this.appServ = appServ;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Dojo> allDojos = this.appServ.getAllDojos();
		model.addAttribute("allDojos", allDojos);
		model.addAttribute("dojo", new Dojo());
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			this.appServ.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/add/ninja")
	public String addNinja(Model model) {
		model.addAttribute("ninja", new Ninja());
		model.addAttribute("allDojos", this.appServ.getAllDojos());
		return "createninja.jsp";
	}
	
	@PostMapping("/create/ninja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allDojos", this.appServ.getAllDojos());
			return "createninja.jsp";
		}else {
			this.appServ.createNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String dojoDetails(@PathVariable("id") Long id, Model model) {
		Dojo showDojo = this.appServ.getOneDojo(id);
		model.addAttribute("showDojo", showDojo);
		return "showdojo.jsp";
	}
}