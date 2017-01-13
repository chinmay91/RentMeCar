package com.rentmecar.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.rentmecar.controller.pojo.UserProfile;
import com.rentmecar.service.IUserAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:iUserServiceMock.xml",
		"file:src/main/webapp/WEB-INF/agora-servlet.xml" })
@WebAppConfiguration
public class UserAccountTest {

	@Autowired
	private IUserAccountService iUserAccount;

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext; // this is pointing to
															// spring web
															// application
															// context container

	@Before
	public void setUp() {
		// create mock object of IUserService i.e. service
		// layer...........................
		// iUserService = Mockito.mock(IUserService.class);
		// We have to reset our mock between tests because the mock objects
		// are managed by the Spring container. If we would not reset them,
		// stubbing and verified behavior would "leak" from one test to another.
		Mockito.reset(iUserAccount);
		// Main entry point for server-side Spring MVC test support.
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Ignore
	public void testCustSignUpGet() {

	}

	@Ignore
	public void testCustSignUpPost() {

	}

	@Ignore
	public void testLoginGet() {

	}

	@Test
	public void testLoginPostValidUsernamePassword() throws Exception {
		UserProfile up = new UserProfile();
		up.setfName("Chinmay");
		up.setlName("Chapla");
		up.setRole("Super_Admin");
		up.setuId(1);
		up.setUsername("chinmay91");
		when(iUserAccount.login("A", "B")).thenReturn(up);
		mockMvc.perform(post("/v1/userLogin").contentType(new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8")))
                .content("\"username\":\"A\",\"password\":\"B\"")
        ).andExpect(status().isOk());

		// here we are verifying method invocation
		// frequency...........................
		verify(iUserAccount, times(1)).login("A","B");
		//verifyNoMoreInteractions(iUserService);
	}

	@Test
	public void testLoginPostInvalidUsernamePassword() {

	}

}
