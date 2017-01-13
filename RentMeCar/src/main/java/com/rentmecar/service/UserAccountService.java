package com.rentmecar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rentmecar.controller.pojo.CustomerSignUp;
import com.rentmecar.controller.pojo.UserProfile;
import com.rentmecar.dao.IUserDao;
import com.rentmecar.dao.entity.users.CustomerProfile;

@Service("UserAccountService")
public class UserAccountService implements IUserAccountService {

	@Autowired
	private IUserDao iUserDao;
	
	private PasswordEncoder bCryptEncoder;
	
	@Override
	public String signUp(CustomerSignUp customer) {
		// TODO Auto-generated method stub
		
		//////////////////////

		bCryptEncoder = new BCryptPasswordEncoder();
		/////////
		
		
		CustomerProfile customerDao = new CustomerProfile();
		customerDao.setfName(customer.getfName());
		customerDao.setlName(customer.getlName());
		customerDao.setAge(customer.getAge());
		customerDao.seteMail(customer.geteMail());
		customerDao.setGender(customer.getGender());
		//String hashedPassword = bCryptEncoder.encode(customer.getPassword());
		customerDao.setPassword(bCryptEncoder.encode(customer.getPassword()));
		customerDao.setRole("USER");
		customerDao.setUsername(customer.getUsername());
		iUserDao.signup(customerDao);
		return null;
	}

	@Override
	public UserProfile login(String username, String password) {
		// TODO Auto-generated method stub
		return new UserProfile();
	}

	@Override
	public int getUId(String name) {
		// TODO Auto-generated method stub
		int uId = iUserDao.getUId(name);
		if(uId < 1){
			return -1;
		}
		return uId;
	}

	@Override
	public UserProfile getUserProfile(int uId) {
		// TODO Auto-generated method stub
		UserProfile profile = new UserProfile();
		CustomerProfile cp = iUserDao.getUserProfile(uId);
		if(cp == null)
			return null;
		profile.setfName(cp.getfName());
		profile.setlName(cp.getlName());
		profile.setRole(cp.getRole());
		profile.setUsername(cp.getUsername());
		profile.setuId(cp.getuId());
		return profile;
	}

}
