package com.codewithsameer.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsameer.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
