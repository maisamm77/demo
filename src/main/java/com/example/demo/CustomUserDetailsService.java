package com.example.demo;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.*;

import java.util.*;

public class CustomUserDetailsService implements UserDetailsService {

	private static List<User> dummyUsers = new ArrayList<>();


	public CustomUserDetailsService() {
		dummyUsers.add(new User("john","{noop}secret", "USER"));
		dummyUsers.add(new User("admin", "{noop}supersecret", "ADMIN"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = dummyUsers.stream()
				.filter(u -> u.getName().equals(username)).findAny();

		if(!user.isPresent()){
			throw new UsernameNotFoundException("User not found :" + username);
		}

		return mapUserDetails(user.get());
	}

	private UserDetails mapUserDetails(User user){
		return org.springframework.security.core.userdetails.User.withUsername(user.getName())
				.password(user.getPassword())
				.roles(user.getRole()).build();
	}
}
