package com.codextrees.web.controllers.admin;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codextrees.web.common.APIResponse;
import com.codextrees.web.models.Article;
import com.codextrees.web.service.ArticleService;

@Controller
@RequestMapping("/admin/")
public class AdminArticleController {
		
		@Autowired
		ArticleService articleService;
		@RequestMapping("/createarticle")
		public String createArticleForm(Model model) {
			model.addAttribute("articledetails", new Article());
			return "admin/article/createarticle";
		}
		
		//individual article template
			@RequestMapping("/t/{topic}/{article}")
			public String getArticle(HttpServletResponse response, @PathVariable("topic") String topic_url,@PathVariable("article") String article_url,Model model) {
				APIResponse apiResponse = articleService.getApiArticleByUrl(topic_url,article_url);
				response.setStatus(apiResponse.getStatus());
				model.addAttribute("articledetails",apiResponse.getData());
				model.addAttribute("pageTitle",apiResponse.getTitle());	
				return "admin/article/article";
			}
			
			//all articles template
			@RequestMapping("/articles")
			public String getAllArticles(HttpServletResponse response,Model model) {
				APIResponse apiResponse = articleService.getArticles();	
				response.setStatus(apiResponse.getStatus());
				model.addAttribute("articles",apiResponse.getData());
				model.addAttribute("pageTitle","Articles");	
				return "admin/article/articles";
			}
			
			@RequestMapping("/t/{topic}/{article}/edit")
			public String editArticleHTML(HttpServletResponse response, @PathVariable("topic") String topic_url,@PathVariable("article") String article_url,Model model) {
				APIResponse apiResponse = articleService.getApiArticleByUrl(topic_url,article_url);
				response.setStatus(apiResponse.getStatus());
				model.addAttribute("articledetails",apiResponse.getData());
				model.addAttribute("pageTitle",apiResponse.getTitle());	
				return "admin/article/editarticlehtml";
			}
			
				
	}