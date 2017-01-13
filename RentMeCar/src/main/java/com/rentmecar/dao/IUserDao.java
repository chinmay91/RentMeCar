package com.rentmecar.dao;

import com.rentmecar.dao.entity.users.Credentials;
import com.rentmecar.dao.entity.users.CustomerProfile;

public interface IUserDao {
	public String signup(CustomerProfile custProf);

	public Credentials findUserByUsername(String username);

	public int getUId(String name);

	public CustomerProfile getUserProfile(int uId);
}