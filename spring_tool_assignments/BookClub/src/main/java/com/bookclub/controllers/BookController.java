package com.bookclub.controllers;

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

import com.bookclub.models.Book;
import com.bookclub.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/books/new")
	public String addNewBook(Model model, HttpSession session) {
		model.addAttribute("book", new Book());
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		return "addBook.jsp";
	}
	
	@PostMapping("/books/create")
	public String createNewBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "addBook.jsp";
		}
		this.bookService.createNewBook(book);
		return "redirect:/home";
	}
	
	@RequestMapping("/books/details/{id}")
	public String getBookDetails(@PathVariable("id") Long id, Model model, HttpSession session) {
		Book bookDetail = this.bookService.getOneBook(id);
		model.addAttribute("bookDetail", bookDetail);
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		return "bookDetail.jsp";
	}
	
	@RequestMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		Book book = this.bookService.getOneBook(id);
		model.addAttribute("book", book);
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		if(idOfLoggedInUser == book.getUploader().getId()) {
			return "editBook.jsp";
		}else {
			return "redirect:/home";
		}
	}
	
	@PutMapping("/books/update/{id}")
	public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		this.bookService.updateBook(book);
		return "redirect:/home";
	}
	
	@RequestMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		this.bookService.deleteBook(id);
		return "redirect:/home";
	}
}
