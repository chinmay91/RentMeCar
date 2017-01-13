package com.rentmecar.rest.security.angularjs.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserData implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<? extends GrantedAuthority> authoroties = null;
	private String username = null;
	private String password = null;
	private boolean status = false;
	private int uId;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authoroties;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setList(Collection<? extends GrantedAuthority> authoroties) {
		this.authoroties = authoroties;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}
	
}
