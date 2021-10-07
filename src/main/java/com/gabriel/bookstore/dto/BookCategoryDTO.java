package com.gabriel.bookstore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.gabriel.bookstore.domain.BookCategory;

public class BookCategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "NAME field must not be empty.")
	@Length(min = 3, max = 100, message = "NAME field must be between 3 and 100 characters.")
	private String name;
	
	@NotEmpty(message = "DESCRIPTION field must not be empty.")
	@Length(min = 3, max = 200, message = "DESCRIPTION field must be between 3 and 200 characters.")
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
