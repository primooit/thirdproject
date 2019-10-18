package com.primooit.thidproject.api.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.primooit.thidproject.api.security.entity.Posts;

public class Response<T> {

	private T data;

	private List<String> errors;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setData(Optional<Posts> posts) {
		this.data = (T) posts;

	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	
	
}
