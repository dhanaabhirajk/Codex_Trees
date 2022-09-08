package com.codextrees.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("/admin/home")
	public String getAdminPage() {
		
		return "admin/adminpage";
	}
 	
	@RequestMapping("/google3752f5be1fbf25c2.html")
	public String verifySearchConsole() {
		
		return "google3752f5be1fbf25c2";
	}
 	
	
	
}
