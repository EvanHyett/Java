package com.bookclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookclub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
