package com.gabriel.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
