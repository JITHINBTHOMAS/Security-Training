package com.ust.secure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.secure.entity.User;
import com.ust.secure.repository.UserRepository;
@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User register(User user) {
		return repo.save(user);
	}

}
