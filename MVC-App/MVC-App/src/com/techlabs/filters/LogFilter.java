package com.techlabs.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LogFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("Inside Filter destroy() method");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		String IP = request.getRemoteAddr();
		System.out.println("Request came from " + IP);
		System.out.println("Time is " + new Date().toString()
				+ " before calling the sevlet");
		arg2.doFilter(arg0, arg1);
		System.out.println("Time is " + new Date().toString()
				+ " after calling the servlet");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Inside Filter init() method");
	}

}
