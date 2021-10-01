package com.gabriel.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.bookstore.domain.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> { //IF DOESNT WORK, CHANGE OBJECT ID FROM int TO Integer

}
