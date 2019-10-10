package com.primooit.thidproject.api.security.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CurrentUserTest {

	@Test
	public void currentUserTest() {
		CurrentUser currentUser = new CurrentUser(null, null);
		
		assertEquals(null, currentUser.getToken(), null);
		
	}


}
