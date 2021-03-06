package com.gabriel.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class BookCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "NAME field must not be empty.")
	@Length(min = 3, max = 100, message = "NAME field must be between 3 and 100 characters.")
	private String name;
	
	@NotEmpty(message = "DESCRIPTION field must not be empty.")
	@Length(min = 3, max = 200, message = "DESCRIPTION field must be between 3 and 200 characters.")
	private String description;

	@JsonIgnoreProperties("bookCategory")
	@OneToMany(mappedBy = "bookCategory")
	private List<Book> books = new ArrayList<>();

	public BookCategory() {
		super();
	}

	public BookCategory(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
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
		BookCategory other = (BookCategory) obj;
		return id == other.id;
	}

}
