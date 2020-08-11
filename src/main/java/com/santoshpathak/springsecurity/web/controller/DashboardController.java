/**
 * 
 */
package com.santoshpathak.springsecurity.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author santoshpathak
 *
 */
@Controller
public class DashboardController {
	
	@GetMapping("/dashboard")
	public String getDashBoard() {
		return "dashboard";
	}


}
