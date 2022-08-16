package com.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.models.Book;
import com.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> findAllBooks() {
		return (List<Book>)this.bookRepo.findAll();
	}
	
	public Book createNewBook(Book book) {
		return this.bookRepo.save(book);
	}
	
	public Book getOneBook(Long id) {
		return this.bookRepo.findById(id).orElse(null);
	}
	
	public Book updateBook(Book book) {
		return this.bookRepo.save(book);
	}
	
	public void deleteBook(Long id) {
		this.bookRepo.deleteById(id);
	}
}
