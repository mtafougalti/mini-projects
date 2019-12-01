package com.mt.mp.myuniversity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mt.mp.myuniversity.entities.User;
import com.mt.mp.myuniversity.repositories.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRepository userRepository;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}test").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("user").password("{noop}test").roles("USER");
//		
		auth.userDetailsService(userDetailsService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().anyRequest().authenticated();
		// http.httpBasic();
		http.formLogin();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetailsService detailsService = userName -> {
			User user = userRepository.findByUsername(userName);
			return new UserDetailsImpl(user);
		};
		return detailsService;
	}


}
