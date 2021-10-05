package com.gabriel.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
		List<Book> list = service.findAllbyCategory(id_cat);

		List<BookDTO> listDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	// create
	@PostMapping
	public ResponseEntity<Book> create(@RequestParam(value = "category", defaultValue = "0") Integer id_cat,
			@RequestBody Book obj) {
		Book newObj = service.create(id_cat, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book obj) {

		Book newObj = service.update(id, obj);

		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Book> updatePatch(@PathVariable Integer id, @RequestBody Book obj) {

		Book newObj = service.findbyId(id);

		if (obj.getAuthor() != null)
			newObj.setAuthor(obj.getAuthor());

		if (obj.getText() != null)
			newObj.setText(obj.getText());

		if (obj.getTitle() != null)
			newObj.setTitle(obj.getTitle());

		service.update(id, newObj);

		return ResponseEntity.ok().body(newObj);
	}
	
	// delete
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
