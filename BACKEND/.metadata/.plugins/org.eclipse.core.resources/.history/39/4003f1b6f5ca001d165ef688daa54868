package com.codewithsameer.blog.services;

import java.util.List;

import com.codewithsameer.blog.entities.Post;
import com.codewithsameer.blog.payloads.PostDto;

public interface PostService {

	
	//create
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete by id
	void deletePost(Integer postId);
	
	//get all post
	//List<PostDto> getAllPost();
	List<PostDto> getAllPost(Integer pageNumber , Integer pageSize);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get all posts by category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	
	List<PostDto> getPostsByUser(Integer userId);
	
	//search
	
	List<Post> searchPosts(String keyword);
	
	
}
