package com.caravan.menu.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.caravan.menu.service.CustomerUserDetailsService;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth-> auth.requestMatchers("/","/menu","/login").permitAll().requestMatchers("/add-menu").hasRole("ADMIN").requestMatchers("/orders").hasAnyRole("ADMIN","STAFF").anyRequest().authenticated()).formLogin(form-> form.loginPage("/login").defaultSuccessUrl("/",true).permitAll()).logout(withDefaults());
		
		return http.build();
	}


	@Autowired
	private CustomerUserDetailsService customerUserDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
