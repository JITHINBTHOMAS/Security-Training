package com.ust.secure.config;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ust.secure.model.MyUser;
import com.ust.secure.repository.MyUserRepo;

@Service
public class MyUserDetailService implements UserDetailsService{
	Logger logger  = Logger.getLogger("MyUserDetailService.class");
	
	@Autowired
	private MyUserRepo urepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Optional<MyUser> user = urepo.findByUsername(username);
		logger.info(user.get().getUsername());
		return user.map(MyUserDetails::new)
				.orElseThrow(()->new UsernameNotFoundException("username not found "+user.get().getUsername()));
		
	}
}
