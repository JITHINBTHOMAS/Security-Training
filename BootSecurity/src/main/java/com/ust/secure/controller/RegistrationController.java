package com.ust.secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.secure.model.MyUser;
import com.ust.secure.repository.MyUserRepo;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	MyUserRepo urepo;
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/add")
	public MyUser User(@RequestBody MyUser user) {
		user.setPassword(encoder.encode(user.getPassword()));
			return urepo.save(user);
	}
}
