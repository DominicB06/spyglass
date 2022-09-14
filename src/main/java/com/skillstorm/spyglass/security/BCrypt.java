package com.skillstorm.spyglass.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

public class BCrypt {
	
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
