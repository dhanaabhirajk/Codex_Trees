package com.codextrees.web.controllers.admin.rest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codextrees.web.common.APIResponse;
import com.codextrees.web.models.Article;
import com.codextrees.web.service.ArticleService;

@RestController
public class AdminRestArticleController {
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
		APIResponse apiResponse = articleService.getArticles(false);
		return apiResponse;
	}
	//api for individual article
//	@RequestMapping("/api/{topic}/{url}")
//	public APIResponse getArticleByUrl(@PathVariable("url") String url) {
//		APIResponse apiResponse = articleService.getApiArticleByUrl(url);
//		return apiResponse;
//	}
	
	
	@PostMapping("/admin/article/publish")
	@ResponseBody
	public APIResponse publishArticle(@RequestParam(value = "articleId",required = true) long articleId	) {
		APIResponse apiResponse = new APIResponse();
		apiResponse = articleService.changePublishArticle(true, articleId);
		if(apiResponse.getData().equals("success")) {
			apiResponse.setData("Published");
		}
		
		return apiResponse;
	}
	
	
	@PostMapping("/admin/article/unpublish")
	@ResponseBody
	public APIResponse unpublishArticle(@RequestParam(value = "articleId",required = true) long articleId	) {
		APIResponse apiResponse = new APIResponse();
		apiResponse = articleService.changePublishArticle(false, articleId);
		if(apiResponse.getData().equals("success")) {
			apiResponse.setData("Unpublished");
		}
		return apiResponse;
	}

	@PostMapping("/admin/article/updatehtml")
	@ResponseBody
	public APIResponse updateArticleHtml(@RequestParam(value = "articleId",required = true) long articleId, @RequestParam(value = "htmlBody",required = true) String htmlBody 	) {
		APIResponse apiResponse = new APIResponse();
		apiResponse = articleService.updateArticleHtml(htmlBody, articleId);
		if(apiResponse.getData().equals("success")) {
			apiResponse.setData("Article Updated");
		}
		return apiResponse;
	}
	
}
