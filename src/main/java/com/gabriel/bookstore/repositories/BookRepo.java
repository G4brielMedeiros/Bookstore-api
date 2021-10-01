package com.gabriel.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.bookstore.domain.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> { //IF DOESNT WORK, CHANGE OBJECT ID FROM int TO Integer

}
