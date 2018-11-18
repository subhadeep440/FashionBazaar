package com.subhadeep.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.subhadeep.DAO.UserDetailDAO;
import com.subhadeep.Mainproject.UserDetail;

 @Controller
public class RegisterController {
	 
	 @Autowired
		UserDetailDAO userDetailDAO;
	 @RequestMapping(value="/registerUser",method=RequestMethod.POST)
		public String insertUser(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("CustomerName")String CustomerName,@RequestParam("emailId")String emailId,@RequestParam("mobileNo")String mobileNo,@RequestParam("address")String address){
			
			UserDetail user=new UserDetail();
			user.setUsername(username);
			user.setPassword(password);
			user.setCustomerName(CustomerName);
			user.setEmailId(emailId);
			user.setAddress(address);
			user.setMobileNo(mobileNo);
			user.setEnabled(true);
		    user.setRole("ROLE_USER");
			
			userDetailDAO.registerUser(user);
	
			return "Register";
			
		}
		
		@RequestMapping(value="/UpdateUser")
		public String showUpdateUserPage()
		{
			return "UpdateUser";
		}
		
		@RequestMapping(value="/updateUser",method=RequestMethod.POST)
		public String UpdateUser(@RequestParam("username")String username,@RequestParam("newpassword")String password,@RequestParam("newemailId")String emailId,@RequestParam("newaddress")String address){
			
			UserDetail user=(UserDetail)userDetailDAO.getUser(username);
			String custname=user.getCustomerName();
			user.setPassword(password);
			user.setCustomerName(custname);
			user.setEmailId(emailId);
			user.setAddress(address);
			user.setEnabled(true);
			user.setRole("ROLE_USER");
			
			userDetailDAO.updateUser(user);
			
			return "Login";
			
		}
		
		
		
	}

