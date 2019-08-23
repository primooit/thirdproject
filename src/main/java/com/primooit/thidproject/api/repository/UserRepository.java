package com.primooit.thidproject.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.primooit.thidproject.api.security.entity.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	User findByEmail(String email);

}
