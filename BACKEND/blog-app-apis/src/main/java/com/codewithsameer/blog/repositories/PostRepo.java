package com.codewithsameer.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsameer.blog.entities.Category;
import com.codewithsameer.blog.entities.Post;
import com.codewithsameer.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
}
