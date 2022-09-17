package com.codextrees.web.controllers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codextrees.web.models.Article;
import com.codextrees.web.models.Post;
import com.codextrees.web.service.ArticleService;

@RestController
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/c-lang/{topic}")
	public String getCLangTopic(@PathVariable("topic") String topic) {
		try {
			Article article = articleService.getPostByUrl(topic);
			if(article==null) {
				return "Not found";
			}
			return article.getHtmlBody()
					.replaceFirst(
                    "(<title>[A-Za-z0-9\\s]+</title>)",
                    "<title>"+article.getTitle()+"</title>");
		}
		catch(Exception e) {
			return "Not Found";
		}
		
	}
	
	
	@PostMapping("/admin/createarticle")
	@ResponseBody
	public String createArticle(@ModelAttribute("articledetails") Article article) {
		article.setCreatedAt(DateTime.now());
		article.setUpdatedAt(DateTime.now());
		String status = articleService.createArticle(article);
		return status;
	}
}
