package com.bae.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CoreService {
	
	public ResponseEntity<Object> findByNumber(String user, String search);

	boolean checkUser(String user, String search);

}
