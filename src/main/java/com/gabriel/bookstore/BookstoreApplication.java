package com.gabriel.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabriel.bookstore.domain.Book;
import com.gabriel.bookstore.domain.BookCategory;
import com.gabriel.bookstore.repositories.BookRepo;
import com.gabriel.bookstore.repositories.CategoryRepo;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private BookRepo bookRepo;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BookCategory cat1 = new BookCategory(null, "tech", "tech books");
		
		Book b1 = new Book(null, "Awesome Book", "John", "Awesome book about stuff that happens", cat1);
		
		cat1.getBooks().addAll(Arrays.asList(b1));
		
		this.categoryRepo.saveAll(Arrays.asList(cat1));
		this.bookRepo.saveAll(Arrays.asList(b1));
		
		
	}

}
