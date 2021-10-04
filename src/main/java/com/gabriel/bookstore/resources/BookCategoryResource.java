package com.gabriel.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.bookstore.domain.BookCategory;
import com.gabriel.bookstore.services.BookCategoryService;

@RestController
@RequestMapping(value = "/categories")
public class BookCategoryResource {

	@Autowired
	private BookCategoryService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BookCategory> findById(@PathVariable Integer id) {
		BookCategory obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
