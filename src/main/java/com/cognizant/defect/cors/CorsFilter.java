package com.cognizant.defect.cors;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CorsFilter extends OncePerRequestFilter {

	public static final String CREDENTIALS_NAME = "Access-Control-Allow-Credentials";
	public static final String ORIGIN_NAME = "Access-Control-Allow-Origin";
	public static final String METHODS_NAME = "Access-Control-Allow-Methods";
	public static final String HEADERS_NAME = "Access-Control-Allow-Headers";
	public static final String MAX_AGE_NAME = "Access-Control-Max-Age";

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.setHeader(CREDENTIALS_NAME, "true");
		response.setHeader(ORIGIN_NAME, "http://10.227.87.79:8080");
		response.setHeader(METHODS_NAME, "GET, OPTIONS, POST, PUT, DELETE");
		response.setHeader(HEADERS_NAME, "Origin, X-Requested-With, Content-Type, Accept");
		response.setHeader(MAX_AGE_NAME, "3600");
		if (request.getMethod().equals("OPTIONS")) {
			try {
				response.getWriter().print("OK");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}
}