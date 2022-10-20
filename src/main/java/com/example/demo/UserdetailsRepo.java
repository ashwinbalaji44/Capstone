package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserdetailsRepo extends JpaRepository<Userdetails,Integer>{
	@Query("select userdetail from Userdetails userdetail where userdetail.emailid=?1")
	public Userdetails findByEmail(String var);
}
