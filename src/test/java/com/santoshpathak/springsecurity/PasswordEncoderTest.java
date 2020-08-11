/**
 * 
 */
package com.santoshpathak.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author santoshpathak
 *
 */
public class PasswordEncoderTest {
	
	@Test
	public void generateEncodedPasswordTest() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPasswordString = passwordEncoder.encode("benpassword");
		System.out.println("Encoded password for santosh::" +encodedPasswordString);
		
	}

}
