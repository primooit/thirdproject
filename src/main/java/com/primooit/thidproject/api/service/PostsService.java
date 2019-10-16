package com.primooit.thidproject.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.primooit.thidproject.api.security.entity.Posts;

@Component
public interface PostsService {
	
	Posts createOrUpdate(Posts posts);
	
	Optional<Posts> findById(String postId);
	
	void delete(String postId);
	
	Page<Posts> listPosts(int page, int count);
	
	Page<Posts> findByNumber(int page, int count, Integer number);
	
	Iterable<Posts> findAll();
	
	
	
	
}
