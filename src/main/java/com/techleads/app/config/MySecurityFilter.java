package com.techleads.app.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;



public class MySecurityFilter implements Filter {
Logger logger =org.slf4j.LoggerFactory.getLogger(MySecurityFilter.class);
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("Before chain.doFilter(request, response)");
		chain.doFilter(request, response);
		logger.info("After chain.doFilter(request, response)");

	}

}
