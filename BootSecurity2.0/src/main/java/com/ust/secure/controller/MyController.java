package com.ust.secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.secure.entity.UserTO;
import com.ust.secure.util.MyJwtUtil;

@RestController
public class MyController {
	

	    @GetMapping("/")
	    public String welcome() {
	        return "Home page";
	    }
	    @GetMapping("/api1")
	    public String api1() {
	        return "api1 !!";
	    }
	    @GetMapping("/api2")
	    public String api2() {
	        return "api2 !!";
	    }
	    @PostMapping("/api3")
	    public String api3(@RequestBody UserTO userTO) {
	        return "api3 !!";
	    }
	    @PostMapping("/api4")
	    public String api4(@RequestBody UserTO userTO) {
	        return "api4 !!";
	    }

	    @Autowired
	    private AuthenticationManager authenticationManager;
	    @Autowired
	    private MyJwtUtil myJwtUtil;

	    @PostMapping("/authenticate")
	    public String generateToken(@RequestBody UserTO userTO) throws Exception {
	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(userTO.getUserName(), userTO.getPassword())
	            );
	        } catch (Exception ex) {
	            throw new Exception("invalid username/password");
	        }
	        return myJwtUtil.generateToken(userTO.getUserName());
	    }
	}

