package com.techleads.app.config;

import java.util.Arrays;
import java.util.Collections;

import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private MyAuthProvider myAuthProvider;
	
	

	@Autowired
	public void setMyAuthProvider(MyAuthProvider myAuthProvider) {
		this.myAuthProvider = myAuthProvider;
	}

	@Autowired
	public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
//		http.formLogin();
		http.authorizeRequests().antMatchers("/welcome").authenticated().anyRequest().permitAll();
		http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
//		http.authorizeRequests().antMatchers("/welcome").authenticated().anyRequest().denyAll();
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		InMemoryUserDetailsManager memoryUserDetailsManager = new InMemoryUserDetailsManager();
//		UserDetails user = User.withUsername("teja").password(bCryptPasswordEncoder.encode("admin")).authorities("read")
//				.build();
//
//		memoryUserDetailsManager.createUser(user);
//		auth.userDetailsService(memoryUserDetailsManager);
//	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(myAuthProvider);
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
