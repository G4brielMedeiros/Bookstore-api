package com.gabriel.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.bookstore.DTOs.BookCategoryDTO;
import com.gabriel.bookstore.domain.BookCategory;
import com.gabriel.bookstore.services.BookCategoryService;

@RestController
@RequestMapping("/categories")
public class BookCategoryResource {

	@Autowired
	private BookCategoryService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<BookCategory> findById(@PathVariable Integer id) {
		BookCategory obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<BookCategoryDTO>> findAll() {
		List<BookCategory> list = service.findAll();
		List<BookCategoryDTO> listDTO = 
				list.stream()
					.map(obj -> new BookCategoryDTO(obj))
					.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
}
