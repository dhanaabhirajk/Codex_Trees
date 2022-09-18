package com.codextrees.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	//individual article template
	@RequestMapping("/c-lang/{topic}")
	public String getArticle() {
		return "article/article";
	}
	//all articles template
		@RequestMapping("/articles")
		public String getAllArticles() {
			return "article/articles";
		}
		
	//individual topic template
	@RequestMapping("/t/{topic}")
	public String getTopic() {
		return "topic/topic";
	}
		
	//all topics templates
	@RequestMapping("/topics")
	public String getAllTopics() {
		return "topic/topics";
	}
	
	
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
	
//	@RequestMapping(value = "/sitemap.xml",produces=MediaType.APPLICATION_XML_VALUE)
//	public String getSitemap() {
//	
//		return "../static/html/sitemap.xml";
//	}
}
