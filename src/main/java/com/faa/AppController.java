package com.faa;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@Autowired
	//private ProductService service;
	
	@RequestMapping("/")
	public String showHome() {

		return "index";
	}
	
	@RequestMapping("/dashboard")
	public String viewDashboard() {
		return "dashboard";
	}
	
	@RequestMapping("/home")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/editor")
	public String staff() {
		return "editor";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logoutForm() {
		return "logout";
	}
}
