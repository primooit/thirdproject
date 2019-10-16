package com.primooit.thidproject.api.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.primooit.thidproject.api.security.entity.Posts;

public interface PostsRepository extends MongoRepository<Posts, String>{
	
	
	
	Page<Posts> findByTitleIgnoreCaseContaining(String title, Pageable pages);

	
	Page<Posts> findByNumber(Integer number, Pageable pages);

}
