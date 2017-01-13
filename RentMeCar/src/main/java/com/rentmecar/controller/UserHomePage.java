package com.rentmecar.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rentmecar.controller.pojo.UserProfile;
import com.rentmecar.controller.rest.utility.JSONResponse;
import com.rentmecar.service.IUserAccountService;

//http://www.baeldung.com/get-user-in-spring-security

@RestController
@RequestMapping("/user/v1")
public class UserHomePage {
	
	@Autowired
	private IUserAccountService iUserAccountService;

	@RequestMapping(value = "/home", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public JSONResponse getUserHome(Principal principal,Authentication auth) {
		// Above statement should be looked more into detail and try to get uId from Auth or Principal
		int uId = iUserAccountService.getUId(principal.getName());
		
		UserProfile up = iUserAccountService.getUserProfile(uId);
		
		/*System.out.println(authParams);
		byte[] decoded = Base64.getDecoder().decode(authParams);*/
		//System.out.println(decoded);
		JSONResponse response = new JSONResponse();
		if(up == null){
			response.setStatus("200");
			response.setMesssage("No Profile");
			response.setDescription("No profile found for the username!!! Provided credentials were correct+"
					+ " but somehow server managed to create bug for me...");
		}else{
			response.setStatus("200");
			response.setMesssage("OK");
			response.setDescription("OK");
			response.addObject(up);
		}
		
		return response;
	}
}