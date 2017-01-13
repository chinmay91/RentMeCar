package com.rentmecar.rest.security.angularjs;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rentmecar.dao.IUserDao;
import com.rentmecar.dao.entity.users.Credentials;
import com.rentmecar.rest.security.angularjs.model.UserDetailsImpl;

public class UserDetailService implements UserDetailsService {
	
	@Autowired
	private IUserDao iUserDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// Check with dao if username exist and then make customUserData object
		// and set things.
		// Get the authorities associated with the help of username
		// Make a List of authoroties of grantedAuthoroties and set it
		// Then also set password , authoroties and username (also other
		// properties if needed) with
		// customUserData... Then u are all set
		System.out.println("111111111111111111111111111111User name is  : " + username);
		Credentials credentials = iUserDao.findUserByUsername(username);
		Collection<CustomRole> authorities = new ArrayList<CustomRole>();
		authorities.add(new CustomRole(credentials.getRole()));
		UserDetailsImpl userData = new UserDetailsImpl(credentials.getUsername(), credentials.getPassword(), true, true, true, true, authorities);
		//userData.setSalt(credentials.getPassword());
		userData.setuId(credentials.getuId());
		
		//User user = new User(credentials.getUsername(), credentials.getPassword(), true, true, true, true, authorities);
		/*CustomUserData userData = new CustomUserData();
		userData.setUsername(credentials.getUsername());
		userData.setPassword(credentials.getPassword());
		userData.setList(authorities);
		userData.setuId(credentials.getuId());*/
		
		/*CustomUserData userData = new CustomUserData();
		userData.setUsername(credentials.getUsername());
		userData.setPassword(credentials.getPassword());
		userData.setList(authoroties);*/
		return userData;
	}

	private class CustomRole implements GrantedAuthority {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String role;
		
		public CustomRole(){
			role = null;
		}
		
		public CustomRole(String role){
			this.role = role;
		}

		@Override
		public String getAuthority() {
			return role;
		}

		public void setAuthority(String roleName) {
			this.role = roleName;
		}
	}
}
