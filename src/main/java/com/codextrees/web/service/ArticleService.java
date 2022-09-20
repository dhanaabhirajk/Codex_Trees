package com.codextrees.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codextrees.web.common.APIResponse;
import com.codextrees.web.data.ArticleData;
import com.codextrees.web.models.Article;
import com.codextrees.web.models.Topic;
import com.codextrees.web.repository.ArticleRepository;

@Component
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepo;
	public String createArticle(Article article) {
		try {
			articleRepo.save(article);
			return "Article Added";
		}
		catch(Exception e) {
			return "Some Error Occured";
		}
	}
	
	
	public APIResponse getArticles() {
		APIResponse apiResponse = new APIResponse();
		List<Article> articles = articleRepo.getArticles();
		if(articles==null) {
			apiResponse.setStatus(404);
			apiResponse.setError("Not Found");
		}
		ArticleData articleData = new ArticleData();
		articleData.setArticles(articles);
		
		apiResponse.setData(articleData.getArticles());
		return apiResponse;
	}
	
	public APIResponse getApiArticleByUrl(String topic_url,String article_url) {
		APIResponse apiResponse = new APIResponse();
		Article article = articleRepo.getArticleByUrl(topic_url,article_url);;
		if(article==null) {
			apiResponse.setStatus(404);
			apiResponse.setError("Not Found");
		}
			
		apiResponse.setData(article);
		return apiResponse;
	}
	
	public List<Article> getApiArticlesByTopic(Topic topic) {
		
		List<Article> articles = articleRepo.getArticlesByTopic(topic);
		
		return articles;
	}
	
}
