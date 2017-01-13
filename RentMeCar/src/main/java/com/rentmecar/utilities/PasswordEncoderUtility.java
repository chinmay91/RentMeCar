package com.rentmecar.utilities;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtility  {

	//@Bean(name="bCryptEncoder")
	public PasswordEncoder getBCryptEncoder(){
		return new BCryptPasswordEncoder();
	}
	
}