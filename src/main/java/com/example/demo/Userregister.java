package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Userregister {

	@Id
	private String username;
	private String password;
	private String uname;
	private String mobileno;
}
