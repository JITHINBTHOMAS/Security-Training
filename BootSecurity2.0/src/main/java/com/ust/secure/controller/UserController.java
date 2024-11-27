package com.ust.secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.secure.entity.User;
import com.ust.secure.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
@PostMapping("/register")
public User register(@RequestBody User user) {
	return service.register(user);
}
}
