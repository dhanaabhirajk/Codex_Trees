package com.codextrees.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codextrees.web.models.Article;

@Controller
public class AdminHomeController {
	@RequestMapping("/admin/home")
	public String getAdminPage(Model model) {
		model.addAttribute("pageTitle","Admin Home");
		return "admin/adminpage";
	}	
	
	@RequestMapping("/admin/createtopic")
	public String createTopicForm(Model model) {
		model.addAttribute("topicdetails", new Article());
		return "admin/createtopic";
	}
}