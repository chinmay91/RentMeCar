package com.rentmecar.service;

import com.rentmecar.controller.pojo.CustomerSignUp;
import com.rentmecar.controller.pojo.UserProfile;

public interface IUserAccountService {

	public String signUp(CustomerSignUp customer);
	public UserProfile login(String username,String password);
	public int getUId(String name);
	public UserProfile getUserProfile(int uId);
}