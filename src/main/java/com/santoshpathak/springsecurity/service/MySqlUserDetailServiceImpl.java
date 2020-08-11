/**
 * 
 */
package com.santoshpathak.springsecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.santoshpathak.springsecurity.domain.UserDetailImpl;
import com.santoshpathak.springsecurity.domain.Users;
import com.santoshpathak.springsecurity.repos.MySQLRepositories;

/**
 * @author santoshpathak
 *
 */
@Service
public class MySqlUserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	MySQLRepositories mySQLRepositories;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<Users> users = mySQLRepositories.findByUsername(userName);
		
		users.orElseThrow(()-> new UsernameNotFoundException("not found::"+userName));
		
		return users.map(UserDetailImpl::new).get();
	}

}
