package com.rentmecar.rest.security.angularjs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		SecurityUtils.sendError(response, authException, HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
		//response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Authentication token was either missing or invalid." );
	}

}