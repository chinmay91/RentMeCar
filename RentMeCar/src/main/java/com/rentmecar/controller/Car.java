package com.rentmecar.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rentmecar.controller.rest.utility.JSONResponse;
import com.rentmecar.service.IUserAccountService;

@RestController
@RequestMapping("user/v1")
public class Car {

	@Autowired
	private IUserAccountService iUserAccountService;

	@RequestMapping(value = "/search/time", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public JSONResponse searchByTime(@RequestParam(value = "zipcode", required = true) String zipcode,@RequestParam(value = "starttime", required = true) String startTime,@RequestParam(value = "endtime", required = true) String endtime) {
		
		JSONResponse resp = new JSONResponse();
		return resp;
	}

	@RequestMapping(value = "/search/window", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public JSONResponse searchWindow(@RequestParam(value = "zipcode", required = false) String zipcode) {

		JSONResponse resp = new JSONResponse();
		return resp;
	}
}
