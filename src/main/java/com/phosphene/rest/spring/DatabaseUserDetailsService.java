package com.phosphene.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phosphene.rest.models.User;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {
        
	@Autowired(required = true)
	private UserAccountService userAccountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userAccountService.getUserByEmail(username);
		return new MyUserDetails(user);
	}

}
