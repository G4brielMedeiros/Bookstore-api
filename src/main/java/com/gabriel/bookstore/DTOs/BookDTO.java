package com.gabriel.bookstore.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gabriel.bookstore.domain.Book;
import com.gabriel.bookstore.domain.BookCategory;

public class BookDTO {

	private Integer id;
	private String title;
	private String author;
	private String text;
	@JsonIgnoreProperties({"books", "id", "description"})
	private BookCategory bookCategory;

	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDTO(Book obj) {
		super();
		this.id 			= obj.getId();
		this.title 			= obj.getTitle();
		this.author 		= obj.getAuthor();
		this.text 			= obj.getText();
		this.bookCategory 	= obj.getBookCategory();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

}
