package com.caravan.menu.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth-> auth.requestMatchers("/").permitAll().requestMatchers("/add-menu").hasRole("ADMIN").requestMatchers("/orders").hasAnyRole("ADMIN","STAFF").anyRequest().authenticated()).formLogin(withDefaults()).logout(withDefaults());
		
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("admin123").roles("ADMIN").build();
		
		UserDetails staff = User.withDefaultPasswordEncoder().username("staff").password("staff123").roles("STAFF").build();
		
		return new InMemoryUserDetailsManager(admin,staff);
	}
	
}
