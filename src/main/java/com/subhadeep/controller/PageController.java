package com.subhadeep.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/login")
	public String showLogin()
	{
		return "Login";
	}
	
	@RequestMapping("/aboutus")
	public String showAboutUs()
	{
		return "AboutUs";
	}
	
	@RequestMapping("/contactus")
	public String showContactUs()
	{
		return "ContactUs";
	}
	
	@RequestMapping("/register")
	public String showRegister()
	{
		return "Register";
	}
	
	
	@RequestMapping("/")
	public String showHomePage()
	{
		return "index";
	}
}
