package com.codextrees.web.controllers;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codextrees.web.models.Post;

@Controller
public class HomeController {
	
	
	@RequestMapping("/google3752f5be1fbf25c2.html")
	public String verifySearchConsole() {
		
		return "html/google3752f5be1fbf25c2.html";
	}
	
	@RequestMapping("/privacy-policy")
	public String getPrivacyPolicy() {
	
		return "html/privacy-policy.html";
	}
	@RequestMapping("/contact")
	public String getContact(Model model) {
		model.addAttribute("pageTitle", "Contact Us");	
		return "html/contact-us.html";
	}
	
	@RequestMapping(value = "/sitemap.xml",produces=MediaType.TEXT_XML_VALUE)
	public String getSitemap() {
	
		return "sitemap.xml";
	}
}
