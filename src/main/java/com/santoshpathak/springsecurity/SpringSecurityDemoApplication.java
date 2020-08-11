package com.santoshpathak.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.santoshpathak.springsecurity.repos.MySQLRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = MySQLRepositories.class)
public class SpringSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

}
