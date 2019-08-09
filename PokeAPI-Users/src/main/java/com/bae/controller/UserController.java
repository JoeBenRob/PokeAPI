package com.bae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.User;
import com.bae.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	
	private UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/checkUser/{user}/{search}")
	public ResponseEntity<Boolean> checkUser(@PathVariable String user, @PathVariable String search) {
		 boolean check = service.checkUser(user, search);
		 return  new ResponseEntity<Boolean>(check, HttpStatus.OK);
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		service.createUser(user);
		return new ResponseEntity<>("Account Created", HttpStatus.OK);
	}
	
	@GetMapping("/allUser")
	public ResponseEntity<Object> getAllProducts() {
		return new ResponseEntity<>(service.allUser(), HttpStatus.OK);
	}

}
