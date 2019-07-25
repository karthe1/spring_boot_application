package com.karthick.profileapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProfileInfoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProfileInfoApplication.class);
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProfileInfoApplication.class, args);
	}
	
}
