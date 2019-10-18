package com.primooit.thidproject.api.controller;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primooit.thidproject.api.response.Response;
import com.primooit.thidproject.api.security.entity.Posts;
import com.primooit.thidproject.api.security.entity.User;
import com.primooit.thidproject.api.security.jwt.JwtTokenUtil;
import com.primooit.thidproject.api.service.PostsService;
import com.primooit.thidproject.api.service.UserService;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostsController {

	@Autowired
	private PostsService postsService;

	@Autowired
	protected JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@PostMapping()
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Posts>> create(HttpServletRequest request, @RequestBody Posts posts,
			BindingResult result) {
		Response<Posts> response = new Response<Posts>();

		try {
			// validateCreatePosts(posts, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			posts.setDate(new Date());
			posts.setNumber(generateNumber());
			Posts postsPersisted = (Posts) postsService.createOrUpdate(posts);
			response.setData(postsPersisted);

		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok(response);

	}

	private void validateCreatePosts(Posts posts, BindingResult result) {
		if (posts.getTitle() == null) {
			result.addError(new ObjectError("Posts", "Title no information"));
			return;

		}
	}

	public User userFromRequest(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		String email = jwtTokenUtil.getUsernameFromToken(token);
		return userService.findByEmail(email);
	}

	private Integer generateNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	@PutMapping()
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Posts>> update(HttpServletRequest request, @RequestBody Posts posts,
			BindingResult result) {
		Response<Posts> response = new Response<Posts>();
		try {
			// validateUpdatePosts(posts, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			Optional<Posts> postsCurrent = postsService.findById(posts.getTitle());
			Posts postsPersisted = (Posts) postsService.createOrUpdate(posts);
			response.setData(postsPersisted);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	private void validateUpdatePosts(Posts posts, BindingResult result) {
		if (posts.getTitle() == null) {
			result.addError(new ObjectError("Posts", "Id no information"));
			return;
		}
		if (posts.getTitle() == null) {
			result.addError(new ObjectError("Posts", "Title no information"));
			return;
		}
	}

	@GetMapping(value = "{title}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<Response<Posts>> findById(@PathVariable("title") String title) {
		Response<Posts> response = new Response<Posts>();
		Optional<Posts> posts = postsService.findById(title);
		if (posts == null) {
			response.getErrors().add("Register not found id:" + title);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(posts);
		;
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/{title}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<String>> delete(@PathVariable("postId") String title) {
		Response<String> response = new Response<String>();
		Optional<Posts> posts = postsService.findById(title);
		if (posts == null) {
			response.getErrors().add("Register not found id:" + title);
			return ResponseEntity.badRequest().body(response);
		}
		postsService.delete(title);
		return ResponseEntity.ok(new Response<String>());
	}

	@GetMapping(value = "{page}/{count}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<Response<Page<Posts>>> findAll(HttpServletRequest request, @PathVariable int page,
			@PathVariable int count) {

		Response<Page<Posts>> response = new Response<Page<Posts>>();
		Page<Posts> posts = null;
		posts = postsService.listPosts(page, count);
		response.setData(posts);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "{getallposts}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<Response<Posts>> getAllPosts(HttpServletRequest request) {

		Response<Posts> response = new Response<Posts>();
		Iterable<Posts> posts = postsService.findAll();
		response.setData((Posts) posts);
		return ResponseEntity.ok(response);
	}

}
