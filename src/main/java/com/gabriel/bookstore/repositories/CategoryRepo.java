package com.gabriel.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.bookstore.domain.BookCategory;

@Repository
public interface CategoryRepo extends JpaRepository<BookCategory, Integer> {

}
