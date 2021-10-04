package com.gabriel.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.bookstore.domain.Book;
import com.gabriel.bookstore.repositories.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo repo;

	public Book findbyId(Integer id) {
		Optional<Book> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
