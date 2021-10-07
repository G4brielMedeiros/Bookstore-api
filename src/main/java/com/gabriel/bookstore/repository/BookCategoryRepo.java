package com.gabriel.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.bookstore.domain.BookCategory;

@Repository
public interface BookCategoryRepo extends JpaRepository<BookCategory, Integer> {

}
