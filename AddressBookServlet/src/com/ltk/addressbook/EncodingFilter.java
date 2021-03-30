package com.ltk.addressbook;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest req, 
			ServletResponse resp, 
			FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");	
		resp.setCharacterEncoding("UTF-8");
		chain.doFilter(req, resp);
		resp.setContentType("text/html;charset=UTF-8");
		
	}
	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
