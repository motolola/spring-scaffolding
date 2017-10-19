package com.motolola.login.service;

import org.springframework.stereotype.Service;

@Service 
public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("motolola") && password.equals("pass");
	}

}