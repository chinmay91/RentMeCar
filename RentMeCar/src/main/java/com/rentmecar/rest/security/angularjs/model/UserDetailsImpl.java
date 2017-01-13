package com.rentmecar.rest.security.angularjs.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDetailsImpl extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int uId;
	private String salt;

	public UserDetailsImpl(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	public String getSalt() {
		System.out.println("Chalooo Salt was used@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("And salt is  : " + salt);
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}
	
}