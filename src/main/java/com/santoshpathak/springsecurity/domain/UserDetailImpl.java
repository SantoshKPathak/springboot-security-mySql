/**
 * 
 */
package com.santoshpathak.springsecurity.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author santoshpathak
 *
 */
public class UserDetailImpl implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private boolean enabled;
	private Set<Authorities> authorities;
	
	public UserDetailImpl(){}
	
	public UserDetailImpl(Users users){
		username=users.getUsername();
		password=users.getPassword();
		enabled=users.isEnabled();
		authorities = users.getAuthorities();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		System.out.println(authorities);
		grantedAuthorities =authorities
								.stream()
								.map(authority->(new SimpleGrantedAuthority(authority.getAuthority())))
								.collect(Collectors.toList());
		System.out.println(grantedAuthorities);
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	

}
