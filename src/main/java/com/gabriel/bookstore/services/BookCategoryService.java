package com.gabriel.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gabriel.bookstore.DTOs.BookCategoryDTO;
import com.gabriel.bookstore.domain.BookCategory;
import com.gabriel.bookstore.repositories.BookCategoryRepo;
import com.gabriel.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class BookCategoryService {
	
	@Autowired
	private BookCategoryRepo repo;

	public BookCategory findById(Integer id) {
		Optional<BookCategory> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException(
						"Object not found! ID: " + id + " Type:" + BookCategory.class.getName()
						)
				);
	}
	
	public List<BookCategory> findAll() {
		return repo.findAll();
	}
	
	public BookCategory create(BookCategory obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public BookCategory update(Integer id, BookCategoryDTO objDTO) {
		BookCategory obj = this.findById(id);
		obj.setName(objDTO.getName());
		obj.setDescription(objDTO.getDescription());
		return repo.save(obj);
	}

	public void delete(Integer id) {

		this.findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.gabriel.bookstore.services.exceptions.DataIntegrityViolationException
			("Category cannot be deleted; There are books assossiated to it.");
		}
	}
	
	
}
