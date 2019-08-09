package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.service.CoreService;

@RestController
@RequestMapping("/PokeApi")
public class CoreController {

	private CoreService service;
	
	@Autowired 
	CoreController(CoreService service) {
		this.service = service;
	}
	
	CoreController() {
	}
	
	@GetMapping("/PokeNo/{user}/{search}")
	public ResponseEntity<Object> findByNumber(@PathVariable String user, @PathVariable String search) {
		return new ResponseEntity<>(service.findByNumber(user, search), HttpStatus.OK);
	}
}
