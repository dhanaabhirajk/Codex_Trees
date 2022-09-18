package com.codextrees.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codextrees.web.models.Article;

@Controller
public class AdminController {
	@RequestMapping("/admin/home")
	public String getAdminPage() {
		
		return "admin/adminpage";
	}	
	@RequestMapping("/admin/createarticle")
	public String createArticleForm(Model model) {
		model.addAttribute("articledetails", new Article());
		return "admin/createarticle";
	}
	
	@RequestMapping("/admin/createtopic")
	public String createTopicForm(Model model) {
		model.addAttribute("topicdetails", new Article());
		return "admin/createtopic";
	}
	
	@RequestMapping("/admin/articles")
	public String getArticles() {
		return "admin/articles";
	}
	
}
