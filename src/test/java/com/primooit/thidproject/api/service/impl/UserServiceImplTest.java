package com.primooit.thidproject.api.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.primooit.thidproject.api.repository.UserRepository;
import com.primooit.thidproject.api.security.entity.User;
import com.primooit.thidproject.api.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	@Mock
	private UserRepository mockUserRespository;
	
	private UserService userService;
	
	@Before
	public void initialize() {
		
		userService = new UserServiceImpl(mockUserRespository);
	}

	@Test
	public void shouldFindEmailTest() {
		String email = "primooit@hotmail.com";
		String id = "primooit";
		
		User user = new User();
		
		user.setEmail(email);
		user.setId(id);
		
		Mockito.when(mockUserRespository.findByEmail(email)).thenReturn(user);
		
		assertEquals("primooit@hotmail.com", userService.findByEmail(email).getEmail());
		
		
		//User user = userServiceImpl.findByEmail(new Email ("primooit@hotmail.com"));
		
		//assertEquals("primooit@hotmail.com", userServiceImpl.findByEmail());
		
		
	}
}
