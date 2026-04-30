package com.caravan.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.caravan.menu.model.UserEntity;
import com.caravan.menu.repository.UserRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("username not found"));
		
		return User.builder().username(user.getUsername()).password(user.getPassword()).roles(user.getRole()).build();
	}
	
}
