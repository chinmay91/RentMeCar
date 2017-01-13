package com.rentmecar.rest.security.angularjs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	// @Autowired
	// private UserRepo userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		// User user = userService.findByLogin(authentication.getName());
		// SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK,
		// user);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write("User OK");
		response.setStatus(HttpServletResponse.SC_OK);
		System.out.println("User loggeed in!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		writer.flush();
		writer.close();
	}
}