package com.example.demo;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserdetailsDAO {
	
	@Autowired
	UserdetailsRepo repo;
	
	public Userdetails insertdetails(Userdetails e) {
		return repo.save(e);
	}
	
	public Userdetails updateByNo(String email, String phoneno) {
		System.out.println(email);
		Userdetails us=repo.findByEmail(email);
		us.setMobilenum(phoneno);
		return repo.save(us);		
	}
	
	public Userdetails updateByaddress(String email, String address) {
		Userdetails us=repo.findByEmail(email);
		us.setAddress(address);
		return repo.save(us);		
	}
	
	public Userdetails updateBydob(String email, String dob) {
		Userdetails us=repo.findByEmail(email);
		us.setDob(dob);
		return repo.save(us);		
	}
	
	public Userdetails getuser(String name){
		return repo.findByEmail(name);
	}
	
	
	public List<Userdetails> getdetails(){
		return repo.findAll();
	}

	public Userdetails updateuserstatus(String emailid){
		Userdetails us=repo.findByEmail(emailid);
		us.setStatus("Approved");
		Date date = new Date();
		us.setIssuedate(date);
		return repo.save(us);
	}
	
	public void deleteuser(int citid) {
		 repo.deleteById(citid);
		// return "Deleted the citizen id "+citid;
	}
}
