package com.rabbitink.rabbitink.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rabbitink.rabbitink.domain.Address;
import com.rabbitink.rabbitink.domain.Authority;
import com.rabbitink.rabbitink.domain.User;
import com.rabbitink.rabbitink.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User saveUser(User user) {
		String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		Address address = new Address();
		Authority authority = new Authority();

		// only for demonstration - create an "admin" with admin username
		if (user.getEmail().equals("admin")) {

			authority.setAuthority("ROLE_ADMIN");
			user.getAuthorities().add(authority);
			authority.setUser(user);

		} else {

			authority.setAuthority("ROLE_USER");
			user.getAuthorities().add(authority);
			authority.setUser(user);

		}

		address.setUser(user);
		user.setAddress(address);
		user.setPassword(encodedPassword);
		return userRepo.save(user);
	}

	public User findById(Long userId) {
		Optional<User> findById = userRepo.findById(userId);
		return findById.orElse(null);

	}
}
