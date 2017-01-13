package com.rentmecar.rest.security;

public class TokenUtils implements ITokenUtils {

	@Override
	public String getToken(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToken(UserDetails userDetails, Long expiration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validate(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserDetails getUserFromToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
