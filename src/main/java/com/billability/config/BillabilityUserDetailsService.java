package com.billability.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.billability.auth.model.IUserInfoDAO;
//import com.billability.auth.model.UserInfoDAO;
import com.billability.auth.model.UserDAO;

@Service
public class BillabilityUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserInfoDAO userInfoDAO;
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		UserDAO activeUserInfo = userInfoDAO.getActiveUser(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority("Delivery Manager");
		UserDetails userDetails = (UserDetails)new User(activeUserInfo.getEmail(),
				activeUserInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
}
