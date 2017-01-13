package com.rentmecar.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;

import javax.xml.bind.JAXB;

import org.apache.cxf.jaxb.attachment.JAXBAttachmentMarshaller;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rentmecar.controller.pojo.CustomerSignUp;
import com.rentmecar.controller.rest.utility.JSONResponse;
import com.rentmecar.service.IUserAccountService;
import com.sun.org.apache.xalan.internal.xsltc.DOM;
import com.sun.org.apache.xalan.internal.xsltc.StripFilter;
import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;

@RestController
@RequestMapping("/user/v1")
public class UserAccount {
	
	private static final Logger logger = Logger.getLogger(UserAccount.class);

	@Autowired
	private IUserAccountService iUserAccount;
	
	// This method should be able to return the userId that will be used in further communication
	// for identifying the user...
	// First find how to find the authenticated username and get its userId
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public JSONResponse getUserHome(@RequestHeader("Authorization") String authParams) {
		System.out.println(authParams);
		byte[] decoded = Base64.getDecoder().decode(authParams);
		System.out.println(decoded);
		JSONResponse response = new JSONResponse();
		
		return response;
	}

	@RequestMapping(value = "/custSignUp", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public CustomerSignUp CustSignUpGet() {
		CustomerSignUp s = new CustomerSignUp();
		s.setlName("First");
		s.setfName("User");
		s.seteMail("a@b.com");
		s.setUsername("Champ");
		s.setPassword("firstPass");
		s.setAge(22);
		s.setGender("M");
		return s;
	}

	@RequestMapping(value = "/custSignUp", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public JSONResponse CustSignUpPost(@RequestBody CustomerSignUp signupForm) {

		iUserAccount.signUp(signupForm);
		JSONResponse res = new JSONResponse();
		res.setStatus("200");
		res.setMesssage("OK");
		res.setDescription("Everything is fine... Now what???");
		return res; // With messsage saying verify accoutn
	}

	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	@ResponseBody
	public String loginGet() {
		return "login";
	}

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse loginPost(@RequestBody String requestBody) {
		ObjectNode node;
		logger.debug("loginPost: " + requestBody);
		try {
			node = new ObjectMapper().readValue(requestBody, ObjectNode.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JSONResponse res = new JSONResponse();
			res.setStatus("200");
			res.setMesssage("Could not parse sent data");
			res.setDescription("While parsing the username and password Exception occured");
			logger.error("Could not parse data: " + e);
			return res;
		}
		String username = node.get("username").textValue();
		String password = node.get("password").textValue();
		logger.debug("[username:password] = [" + username + ":" + password + "]");
		if(username == null || password == null){
			JSONResponse res = new JSONResponse();
			res.setStatus("200");
			res.setMesssage("Username/Password not received");
			res.setDescription("Username and/or Password not sent or received or parsed");
			logger.debug("Username/password not received [username:password] was [" + username + ":" + password + "]");
			return res;
		}
		// Or May be "login" with failure message
		iUserAccount.login(username, password);
		
		return new JSONResponse();
	}
	
/*	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}*/

	/*
	 * @RequestMapping(value="home",method = RequestMethod.GET) public String
	 * getHome(){ return "home"; }
	 * 
	 * @RequestMapping(value="index",method = RequestMethod.GET) public String
	 * getIndex(){ return "home"; }
	 */
}
