package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserregisterRepo extends JpaRepository<Userregister,String> {
	@Query("select userregister from Userregister userregister where userregister.username=?1")
	public Userregister findByname(String name);
	
	@Query("select userregister from Userregister userregister where userregister.password=?1")
	public Userregister findpassword(String name);
}
