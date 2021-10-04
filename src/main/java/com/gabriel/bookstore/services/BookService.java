package com.gabriel.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gabriel.bookstore.DTOs.BookDTO;
import com.gabriel.bookstore.domain.Book;
import com.gabriel.bookstore.repositories.BookRepo;
import com.gabriel.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepo repo;

	public Book findbyId(Integer id) {
		Optional<Book> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException(
				"Object not found! ID: " + id + " Type:" + Book.class.getName()));
	}
	
	public List<Book> findAll() {
		return repo.findAll();
	}
	
	public Book create(Book obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Book update(Integer id, BookDTO objDTO) {
		Book obj = this.findbyId(id);
		obj.setAuthor(objDTO.getAuthor());
		obj.setText(objDTO.getText());
		obj.setTitle(objDTO.getTitle());
		obj.setBookCategory(objDTO.getBookCategory());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		this.findbyId(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.gabriel.bookstore.services.exceptions.DataIntegrityViolationException
			("Book cannot be deleted; There is a category assossiated to it.");
		}
	}
}
