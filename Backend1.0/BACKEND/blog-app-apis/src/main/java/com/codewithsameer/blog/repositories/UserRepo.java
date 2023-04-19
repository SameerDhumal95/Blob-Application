package com.codewithsameer.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsameer.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
