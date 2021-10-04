package com.gabriel.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriel.bookstore.DTOs.BookDTO;
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

	// findAll
	@GetMapping
	public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "category", defaultValue = "0") Integer id_cat) {
		List<Book> list = service.findAll(id_cat);

		List<BookDTO> listDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	// create
	@PostMapping
	public ResponseEntity<Book> create(@RequestBody Book obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> update(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
		
		Book newObj = service.update(id, bookDTO);	
		
		return ResponseEntity.ok().body(new BookDTO(newObj));
	}
	// delete

}
