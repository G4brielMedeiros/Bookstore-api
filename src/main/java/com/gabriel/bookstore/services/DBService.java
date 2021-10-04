package com.gabriel.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.bookstore.domain.Book;
import com.gabriel.bookstore.domain.BookCategory;
import com.gabriel.bookstore.repositories.BookRepo;
import com.gabriel.bookstore.repositories.BookCategoryRepo;

@Service
public class DBService {

	@Autowired
	private BookCategoryRepo categoryRepo;
	@Autowired
	private BookRepo bookRepo;

	public void buildDatabase() {
		BookCategory science = new BookCategory(null, "Science", "Books of Science");
		BookCategory math = new BookCategory(null, "Math", "Books of Math");
		BookCategory history = new BookCategory(null, "History", "Books of History");

		Book b1 = new Book(null, "The Universe", "John", "Awesome book about stuff that happens", science);
		Book b2 = new Book(null, "Linear Algebra", "Sir Mathen", "The guide of Linear Algebra", math);
		Book b3 = new Book(null, "The Revolution", "Mr. OldPerson", "The book of the revolution", history);
		Book b4 = new Book(null, "Quantum Theory", "Science SmartMan", "All about the quantum world", science);
		Book b5 = new Book(null, "Statistics", "MathBoy SirNumber", "The book of stats", math);

		science.getBooks().addAll(Arrays.asList(b1, b4));
		math.getBooks().addAll(Arrays.asList(b2, b5));
		history.getBooks().addAll(Arrays.asList(b3));

		this.categoryRepo.saveAll(Arrays.asList(science, math, history));
		this.bookRepo.saveAll(Arrays.asList(b1, b2, b3, b4, b5));
	}
}
