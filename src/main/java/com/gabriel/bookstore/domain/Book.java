package com.gabriel.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "TITLE field must not be empty.")
	@Length(min = 1, max = 50, message = "TITLE field must be between 1 and 50 characters.")
	private String title;
	
	@NotEmpty(message = "AUTHOR field must not be empty.")
	@Length(min = 3, max = 50, message = "AUTHOR field must be between 3 and 50 characters.")
	private String author;
	
	@NotEmpty(message = "TEXT field must not be empty.")
	@Length(min = 1, max = 2000000, message = "TEXT field must be between 10 and 2,000,000 characters.")
	private String text;

	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private BookCategory bookCategory;

	public Book() {
		super();
	}

	public Book(Integer id, String title, String author, String text, BookCategory bookCategory) {
		super();

		this.id = id;
		this.title = title;
		this.author = author;
		this.text = text;
		this.bookCategory = bookCategory;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return id == other.id;
	}

}
