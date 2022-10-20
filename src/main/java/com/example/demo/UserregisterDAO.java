package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserregisterDAO {

	@Autowired
	UserregisterRepo repo;
	
	public Userregister insert(Userregister u) {
		return repo.save(u);
	}
	
	public Userregister login(Userregister e){
		return repo.save(e);
	}
	
	public Userregister findByUsername(String name) {
		return repo.findByname(name);
	}
	
	public Userregister findByPassword(String name) {
		return repo.findpassword(name);
	}
}
