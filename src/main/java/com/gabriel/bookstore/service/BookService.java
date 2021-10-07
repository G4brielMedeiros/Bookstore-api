package com.gabriel.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.bookstore.domain.Book;
import com.gabriel.bookstore.domain.BookCategory;
import com.gabriel.bookstore.repository.BookRepo;
import com.gabriel.bookstore.service.exception.ObjectNotFoundException;

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
	
	public Book create(Integer id_cat, Book obj) {
		obj.setId(null);
		BookCategory cat = catService.findById(id_cat);
		obj.setBookCategory(cat);
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
		repo.deleteById(id);
	}
}
