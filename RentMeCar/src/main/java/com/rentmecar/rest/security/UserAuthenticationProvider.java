package com.rentmecar.rest.security;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		// TODO Auto-generated method stub
		/*String name = auth.getName();
        String password = auth.getCredentials().toString();
        if (shouldAuthenticateAgainstThirdPartySystem()) {
            // use the credentials and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
        } else {
            return null;
        }*/
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}

}
