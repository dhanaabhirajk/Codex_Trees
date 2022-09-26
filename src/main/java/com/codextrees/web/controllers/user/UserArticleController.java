package com.codextrees.web.controllers.user;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codextrees.web.common.APIResponse;
import com.codextrees.web.service.ArticleService;


@Controller
public class UserArticleController {
	
	@Autowired
	ArticleService articleService;
	//individual article template
		@RequestMapping("/t/{topic}/{article}")
		public String getArticle(HttpServletResponse response, @PathVariable("topic") String topic_url,@PathVariable("article") String article_url,Model model) {
			APIResponse apiResponse = articleService.getApiArticleByUrl(topic_url,article_url, true);
			response.setStatus(apiResponse.getStatus());
			if(apiResponse.getData()==null) {
				return "html/pagenotfound";
			}
			model.addAttribute("articledetails",apiResponse.getData());
			model.addAttribute("pageTitle",apiResponse.getTitle());	
			return "article/article";
		}
		
		//all articles template
		@RequestMapping("/articles")
		public String getAllArticles(HttpServletResponse response,Model model) {
			APIResponse apiResponse = articleService.getArticles(true);	
			response.setStatus(apiResponse.getStatus());
			model.addAttribute("articles",apiResponse.getData());
			model.addAttribute("pageTitle","Articles");	
			return "article/articles";
		}
			
			
}
