package com.bae.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bae.persistence.domain.User;

@Service
public interface UserService {
	
	Boolean checkUser(String number, String search);
	
	User createUser(User user);

	List<User> allUser();
}
