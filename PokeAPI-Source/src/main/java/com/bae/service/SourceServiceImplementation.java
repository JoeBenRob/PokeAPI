package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SourceServiceImplementation implements SourceService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<Object> findByNumber(String search) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<Object> entity = new HttpEntity<Object>("parameters", headers);

		return restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/"+search, HttpMethod.GET, entity, Object.class);

	}
	
}
