package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoreServiceImplementation implements CoreService {

	@Autowired
	private RestTemplate restTemplate;

	public ResponseEntity<Object> findByNumber(String user, String search) {

		boolean check = checkUser(user, search);

		if (check == true) {
			ResponseEntity<Object> exchangePoke = restTemplate.exchange("http://localhost:8084/Source/PokeNo/" + search,
					HttpMethod.GET, null, Object.class);
			return exchangePoke;
		} else {
			return null;
		}
	}

	@Override
	public boolean checkUser(String user, String search) {
		ResponseEntity<Boolean> exchangeUser = restTemplate.exchange("http://localhost:8082/User/checkUser/" + user + "/" + search,
				HttpMethod.GET, null, Boolean.class);
		return exchangeUser.getBody();
		
	}
}
