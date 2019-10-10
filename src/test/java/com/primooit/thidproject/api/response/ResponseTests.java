package com.primooit.thidproject.api.response;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ResponseTests {

	@Test
	public void validArrayIfErrorsAreEmptyTest() {
		Response response = new Response();
		
		response.setErrors(null);
		
		List<String> errors = response.getErrors();
		
		assertNotNull("Array nao eh nulo", errors);
	}

	@Test
	public void returnCorrectErrorArrayTest() {
		Response response = new Response();
		
		ArrayList errors = new ArrayList<String>();
		
		errors.add("Teste erro 1");
		errors.add("Teste erro 2");
		
		response.setErrors(errors);
		
		assertEquals("Erro na validacao da primeira mensagem de erro", errors.get(0), response.getErrors().get(0));
		assertEquals("Erro na validacao da segundas mensagem de erro", errors.get(1), response.getErrors().get(1));
	}
}
