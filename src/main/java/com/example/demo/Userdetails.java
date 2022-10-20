package com.example.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Userdetails {
	
	 @Id
	    @GeneratedValue(generator = "sequence-generator")
	    @GenericGenerator( name = "sequence-generator",strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	      parameters = {
	        @Parameter(name = "sequence_name", value = "user_sequence"),
	        @Parameter(name = "initial_value", value = "10000"),
	        @Parameter(name = "increment_size", value = "1")
	        })
	
	private int citizenid;
	private String emailid;

	
	private String name;
	private String dob;
	private String address;
	
	private String mobilenum;
	private String gender;
	private Date issuedate;
	
	private String passportid;
	private String status;
	private int appid;
	private Date dateofapp;
	
}
