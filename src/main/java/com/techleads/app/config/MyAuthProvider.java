package com.techleads.app.config;

import java.util.Arrays;
import java.util.function.Predicate;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
@Component
public class MyAuthProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		
		Predicate<String> p1=(name)->name.equalsIgnoreCase("teja");
		Predicate<String> p2=(pwd)->pwd.equalsIgnoreCase("madhav");
		if(p1.test(username) && p2.test(password)) {
			return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
		}else {
			throw  new BadCredentialsException("Invalid credentials");
		}
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
