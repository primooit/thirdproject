package com.primooit.thidproject.api.security.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.primooit.thidproject.api.enums.PriorityEnum;
import com.primooit.thidproject.api.enums.StatusEnum;

public class Posts {

	@Id
	
	private String postId;
	
	@DBRef(lazy = true)
	private Posts posts;
	
	private Date date;
	
	private String title;
	
	private Integer number;
	
	private String description;
	
	private String image;
		


	public String getPost() {
		return postId;
	}

	public void setPost(String post) {
		this.postId = post;
	}

	public Posts getPosts() {
		return posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	
}
