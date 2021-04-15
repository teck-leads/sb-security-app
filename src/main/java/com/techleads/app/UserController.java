package com.techleads.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping(value = "/welcome")
	public String welcome() {
		return "Welcome";
	}
	
	
	@GetMapping(value = "/exit")
	public String exit() {
		return "thanks you";
	}

}
