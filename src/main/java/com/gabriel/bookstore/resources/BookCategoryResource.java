package com.gabriel.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriel.bookstore.DTOs.BookCategoryDTO;
import com.gabriel.bookstore.domain.BookCategory;
import com.gabriel.bookstore.services.BookCategoryService;

@CrossOrigin("*")
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
	
	@PostMapping
	public ResponseEntity<BookCategory> create(@Valid @RequestBody BookCategory obj) {
		
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookCategoryDTO> update(@Valid @PathVariable Integer id, @RequestBody BookCategoryDTO objDTO) {
		
		BookCategory newObj = service.update(id, objDTO);
		
		return ResponseEntity.ok().body(new BookCategoryDTO(newObj));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
