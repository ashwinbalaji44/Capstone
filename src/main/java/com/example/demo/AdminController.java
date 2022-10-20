package com.example.demo;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	UserregisterDAO dao;
	
	@Autowired
	UserdetailsDAO dao2;
	
		static String em;
		
		//Register user
		@PostMapping("/insert")
		public String insert(@RequestBody Userregister u){
			if(u.getPassword().length()>=6 && u.getMobileno().length()==10) {
				dao.insert(u);
				return "Registered Successfully";
			}
			else
				return "Not Registered, Try Again";
		}
			
		//Validation
		@PostMapping("/loginuser")
		public String loginuser(@RequestBody Userregister u){
			String username = u.getUsername();
			String password = u.getPassword();
			if(username!=null && password!=null) {
				if(dao.findByUsername(username).equals(dao.findByPassword(password))) {
					return "Login Success";
				}
				else
				{
					return "Please Register before login";
				}
			}
			else
			{
				return "Enter valid details";
			}
			
		}
	
		//user details insertion
		@PostMapping("/insertdetails")
		public String insertdetail(@RequestBody Userdetails u){
			em=u.getEmailid();
		
			Random randomObj = new Random();
			int randomNumber = randomObj.nextInt(99999);
			String formatted = String.format("%05d", randomNumber);
			int id=Integer.parseInt(formatted);
			u.setAppid(id);
			Date dateapp= new Date();
			u.setDateofapp(dateapp);
			dao2.insertdetails(u);
			return "Registered successfully";
		}
	
		//update by phone number
		@PutMapping("/updatebyno/{no}")
		public Userdetails updateByNumber(@PathVariable String no) {
			System.out.println(em);
			return dao2.updateByNo(em,no);
		}
		
		//update by address
		@PutMapping("/updatebyadd/{address}")
		public Userdetails updateByAddress(@PathVariable String address) {
			return dao2.updateByaddress(em,address);
		}
		
		//update by Date of Birth
		@PutMapping("/updatebydob/{dob}")
		public Userdetails updateByDOB(@PathVariable String dob) {
			return dao2.updateBydob(em,dob);
		}
	
		//user-status
		@GetMapping("/getuser/{name}")
		public Userdetails finduser(@PathVariable String name){
			return dao2.getuser(name);
		}
	
		//admin-side function=> get all users request
		@GetMapping("/getalldetails")
		public List<Userdetails> getalldetails(){
			return dao2.getdetails();
		}
		
		//admin-Approve
		@PutMapping("/updatestatus/{name}")
		public String updateStatus(@PathVariable String name) {
			 dao2.updateuserstatus(name);
			 return "Approved " +name; 
		}
		
		//admin=> delete user
		@DeleteMapping("/deleteuser/{id}")
		public String delete(@PathVariable int id) {
			System.out.println(((Object)id).getClass().getSimpleName());
			 dao2.deleteuser(id);
			 return "Deleted Successfully";
		}
}
