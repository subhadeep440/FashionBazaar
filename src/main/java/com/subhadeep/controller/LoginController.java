package com.subhadeep.controller;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.subhadeep.DAO.ProductDAO;
import com.subhadeep.Mainproject.Product;

@Controller
public class LoginController {

	@Autowired
	ProductDAO productDAO;
	@RequestMapping("/login_success")
	public String successfulLogin(HttpSession session,Model m)
	{
		String page="";
		boolean loggedIn=false;
		SecurityContext securityContext=SecurityContextHolder.getContext();
		Authentication authentication=securityContext.getAuthentication();
		
		String username=authentication.getName();
		
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		for(GrantedAuthority role:roles) 
		{
			session.setAttribute("role",role.getAuthority());
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username",username);
			}
		else
		{
			loggedIn=true;
			page="UserHome";
			session.setAttribute("loggedIn",loggedIn);
			session.setAttribute("username",username);
			List<Product>listProducts=productDAO.getProducts();
			m.addAttribute("listProducts",listProducts);
			
		}
		}
			return page;
	}
	@RequestMapping(value="/UserHome")
	public String showUserHome(Model m)
	{
		List<Product>listProducts=productDAO.getProducts();
		m.addAttribute("listProducts",listProducts);
		return "UserHome";
		
	}
}
	
		
	
		
	


	
		
		
	
		

	

