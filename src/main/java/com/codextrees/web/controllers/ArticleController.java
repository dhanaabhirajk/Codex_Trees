package com.codextrees.web.controllers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codextrees.web.common.APIResponse;
import com.codextrees.web.models.Article;
import com.codextrees.web.service.ArticleService;

@RestController
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	
	
	@PostMapping("/admin/createarticle")
	@ResponseBody
	public String createArticle(@ModelAttribute("articledetails") Article article) {
		article.setCreatedAt(DateTime.now());
		article.setUpdatedAt(DateTime.now());
		String status = articleService.createArticle(article);
		return status;
	}
	//api for all articles
	@RequestMapping("/api/c-lang/all")
	public APIResponse getArticles() {
		APIResponse apiResponse = articleService.getArticles();
		return apiResponse;
	}
	//api for individual article
	@RequestMapping("/api/c-lang/{url}")
	public APIResponse getArticleByUrl(@PathVariable("url") String url) {
		APIResponse apiResponse = articleService.getApiArticleByUrl(url);
		return apiResponse;
	}
		
}
