package com.gabriel.bookstore.DTOs;

import java.io.Serializable;

import com.gabriel.bookstore.domain.BookCategory;

public class BookCategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String description;

	public BookCategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookCategoryDTO(BookCategory obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.description = obj.getDescription();
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

}
