package com.gabriel.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gabriel.bookstore.domain.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

	//@Query("SELECT obj FROM Book obj WHERE obj.bookCategory.id = :id_cat ORDER BY title")
	List<Book> findAllByBookCategoryIdOrderByTitle(@Param(value = "id_cat") Integer id_cat);
	

}
