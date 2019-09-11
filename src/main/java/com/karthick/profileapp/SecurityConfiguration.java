package com.karthick.profileapp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Add your configuration on the auth object
		auth.jdbcAuthentication()
			.dataSource(dataSource);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Add your configuration on the http object
		http.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/readProfiles/**").hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.POST, "/createProfile").hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT, "/updateProfile/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/deleteProfile/**").hasRole("ADMIN")
			.and()
			.csrf().disable()
			.formLogin().disable();
	}
	
}

