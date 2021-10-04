package com.gabriel.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.bookstore.domain.BookCategory;
import com.gabriel.bookstore.repositories.CategoryRepo;

@Service
public class BookCategoryService {
	
	@Autowired
	private CategoryRepo repo;

	public BookCategory findById(Integer id) {
		Optional<BookCategory> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
