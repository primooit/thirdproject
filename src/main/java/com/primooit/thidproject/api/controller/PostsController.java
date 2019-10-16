package com.primooit.thidproject.api.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primooit.thidproject.api.response.Response;
import com.primooit.thidproject.api.security.entity.Posts;
import com.primooit.thidproject.api.security.jwt.JwtTokenUtil;
import com.primooit.thidproject.api.service.PostsService;
import com.primooit.thidproject.api.service.UserService;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins= "*")
public class PostsController {
	
	@Autowired
	private PostsService postsService;
	
	@Autowired
	protected JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserService userService;
	
	public ResponseEntity<Response<Posts>> create(HttpServletRequest request, @RequestBody Posts posts, BindingResult result){
		Response<Posts> response = new Response<Posts>();
		
		try {
			
		}catch(Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);
		
	}
	
	private void validateCreatePosts(Posts posts, BindingResult result) {
		
	}
	

}
