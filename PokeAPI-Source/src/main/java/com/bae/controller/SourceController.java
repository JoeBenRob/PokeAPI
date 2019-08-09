package com.bae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.service.SourceService;


@RestController
@RequestMapping("/Source")
public class SourceController {
	
	SourceService service;
	
	@Autowired
	public SourceController(SourceService service) {
		this.service = service;
	}
	

	public SourceController() {
	}
	
	@GetMapping("/PokeNo/{search}")
	public ResponseEntity<Object> getPrize(@PathVariable String search) {
		return new ResponseEntity<>(service.findByNumber(search), HttpStatus.OK);
	}
}
