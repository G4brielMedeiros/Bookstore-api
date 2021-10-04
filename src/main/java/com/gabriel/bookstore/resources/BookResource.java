package com.gabriel.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.bookstore.domain.Book;
import com.gabriel.bookstore.services.BookService;

@RestController

@RequestMapping("/books")
public class BookResource {
	
	@Autowired
	BookService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable Integer id) {
		Book obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}

}
