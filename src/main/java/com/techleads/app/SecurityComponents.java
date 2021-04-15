package com.techleads.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityComponents {
	public static void main(String[] args) {

		
		Map<String, List<String>> map=new HashMap<>();
		List<String> auth=new ArrayList<>();
		
		auth.add("AuthenticationFilter is a servlet filter class");
		auth.add("This will check if the User is authenticated or not");
		auth.add("If not, send this request to AuthenticationManager");
		
		
		
		map.put("AuthenticationFilter", auth);
		
		map.forEach((k,v)->{
			System.out.println(k);
			v.forEach(System.out::println);
		});
	}
}
