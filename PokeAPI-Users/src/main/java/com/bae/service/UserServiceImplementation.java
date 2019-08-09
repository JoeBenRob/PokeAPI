package com.bae.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.persistence.domain.SentUser;
import com.bae.persistence.domain.User;
import com.bae.persistence.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	private UserRepository repository;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	public UserServiceImplementation(UserRepository repository, RestTemplate restTemplate) {
		this.repository = repository;
	}

	@Override
	public Boolean checkUser(String user, String search) {

		Optional<User> userRes = repository.findById(Long.parseLong(user));
		
		if (userRes.isPresent()) {
			
			userRes.get().setSearch(search);
			sendToQueue(userRes.get());
		}
		return userRes.isPresent();
	}

	private void sendToQueue(User user) {
		SentUser accountToStore = new SentUser(user);
		jmsTemplate.convertAndSend("AuditQueue", accountToStore);
	}

	@Override
	public User createUser(User user) {
		return repository.save(user);
	}

	@Override
	public List<User> allUser() {
		return repository.findAll();
	}
}
