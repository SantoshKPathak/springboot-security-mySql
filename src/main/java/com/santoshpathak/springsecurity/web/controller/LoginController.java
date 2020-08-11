/**
 * 
 */
package com.santoshpathak.springsecurity.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author santoshpathak
 *
 */
@RestController
public class LoginController {

	/*
	 * @GetMapping(value = "/login") public String getLoginpage() { return
	 * "<h1>login page </h1>"; }
	 */
	
	@GetMapping(value = "/")
	public String home() {
		return "<h1>Welcome to the Spring Security Demo Application!!!</h1>";
	}
	
	@GetMapping(value = "/user")
	public String user() {
		return "<h1>Welcome User</h1>";
	}

	@GetMapping(value = "/admin")
	public String admin() {
		return "<h1>Welcome Admin</h1>";
	}
	
}
