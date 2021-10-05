package com.gabriel.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gabriel.bookstore.domain.Book;
import com.gabriel.bookstore.repositories.BookRepo;
import com.gabriel.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepo repo;
	
	@Autowired
	private BookCategoryService catService;

	public Book findbyId(Integer id) {
		Optional<Book> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException(
				"Object not found! ID: " + id + " Type:" + Book.class.getName()));
	}
	
	public List<Book> findAllbyCategory(Integer id_cat) {
		catService.findById(id_cat);
		return repo.findAllByBookCategoryIdOrderByTitle(id_cat);
	}
	
	public Book create(Book obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Book update(Integer id, Book obj) {
		Book newObj = this.findbyId(id);
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Book newObj, Book obj) {

		newObj.setTitle(obj.getTitle());
		newObj.setAuthor(obj.getAuthor());
		newObj.setText(obj.getText());
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
