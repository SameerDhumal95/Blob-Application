package com.codewithsameer.blog.services;

import java.util.List;

import com.codewithsameer.blog.entities.Post;
import com.codewithsameer.blog.payloads.PostDto;
import com.codewithsameer.blog.payloads.PostResponse;

public interface PostService {

	
	//create
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete by id
	void deletePost(Integer postId);
	
	//get all post
	
	PostResponse getAllPost(Integer pageNumber , Integer pageSize,String sortBy,String sortDir);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get all posts by category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	
	List<PostDto> getPostsByUser(Integer userId);
	
	//search
	
	List<PostDto> searchPosts(String keyword);
	
	
}
