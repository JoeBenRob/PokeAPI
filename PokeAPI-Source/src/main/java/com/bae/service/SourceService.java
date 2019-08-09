package com.bae.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SourceService {

	public ResponseEntity<Object> findByNumber(String search);
	
}
