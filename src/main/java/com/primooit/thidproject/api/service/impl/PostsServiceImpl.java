package com.primooit.thidproject.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.primooit.thidproject.api.repository.PostsRepository;
import com.primooit.thidproject.api.security.entity.Bots;
import com.primooit.thidproject.api.security.entity.ChangeStatus;
import com.primooit.thidproject.api.security.entity.Posts;
import com.primooit.thidproject.api.service.PostsService;

@Component
public class PostsServiceImpl implements PostsService {
	
	@Autowired
	private PostsRepository postsRepository;
	
	public Posts createOrUpdate(Posts posts) {
		return this.postsRepository.save(posts);
	}

	public Optional<Posts> findById(String postId) {
		return this.postsRepository.findById(postId);
	}

	public void delete(String postId) {
		this.postsRepository.deleteById(postId);
	}

	public Page<Posts> listPosts(int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.postsRepository.findAll(pages);
	}
	
	public Iterable<Posts> findAll() {
		return this.postsRepository.findAll();
	}
	
	public Page<Posts> findByNumber(int page, int count,Integer number){
		Pageable pages = PageRequest.of(page, count);
		return this.postsRepository.findByNumber(number, pages);
	}
	
	
	
	public Page<Posts> findByTitleIgnoreCaseContaining(int page, int count,String title) {
		Pageable pages = PageRequest.of(page, count);
		return this.postsRepository.
				findByTitleIgnoreCaseContaining(title, pages);
	}




}