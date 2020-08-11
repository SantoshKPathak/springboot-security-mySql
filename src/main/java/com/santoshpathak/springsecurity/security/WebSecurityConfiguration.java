/**
 * 
 */
package com.santoshpathak.springsecurity.security;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author santoshpathak
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	/**
	 * Needed for JDBC authentication only not needed for JPA
	 */
//	@Autowired
//	DataSource dataSource;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	/**
	 * Inmemory Authentication 
	 * 		Who are you? - UserName 
	 * 		Prove it? - Password
	 */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()
//			.passwordEncoder(getPasswordEncoder())
//			.withUser("santosh").password("santosh").roles("USER")
//			.and()
//			.withUser("admin").password("admin").roles("ADMIN");
//	}
	
	/**
	 * JDBC Authentication 
	 * 		Who are you? - UserName 
	 * 		Prove it? - Password
	 */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.jdbcAuthentication()
//			.passwordEncoder(getPasswordEncoder())
//			.dataSource(dataSource);
//	}
	
	/**
	 * JPA Authentication 
	 * 		Who are you? - UserName 
	 * 		Prove it? - Password
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService);
	}


	/**
	 * Authorization 
	 * 		 What do you want?
	 * 		 Are you allowed to do this? YES or NO
	 * 
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//configure from most restrictive to least restrictive order 
		http.authorizeRequests()
				.antMatchers("/admin").hasRole("ADMIN") //most restrictive only admin
				.antMatchers("/user").hasAnyRole("USER","ADMIN") //least restrictive user and admin both
				.antMatchers("/","static/css","static/jss").permitAll()
			    .and().formLogin();
	}

}
