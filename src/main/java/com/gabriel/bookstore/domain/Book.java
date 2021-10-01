package com.gabriel.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String author_name;
	private String text;

	@ManyToOne
	@JoinColumn
	private BookCategory bookCategory;

	public Book() {
		super();
	}

	public Book(Integer id, String title, String author_name, String text, BookCategory bookCategory) {
		super();

		this.id = id;
		this.title = title;
		this.author_name = author_name;
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

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public BookCategory getCategory() {
		return bookCategory;
	}

	public void setCategory(BookCategory category) {
		this.bookCategory = category;
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
