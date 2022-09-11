package com.codextrees.web.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/google3752f5be1fbf25c2.html")
	public String verifySearchConsole() {
		
		return "../static/html/google3752f5be1fbf25c2.html";
	}
	
	@RequestMapping("/privacy-policy")
	public String getPrivacyPolicy() {
	
		return "../static/html/privacy-policy.html";
	}
	@RequestMapping("/contact")
	public String getContact() {
	
		return "../static/html/contact-us.html";
	}
}
