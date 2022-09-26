package com.codextrees.web.service;

import java.util.List;

import org.joda.time.DateTime;
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
			article.setPublish(false);
			articleRepo.save(article);
			return "Article Added";
		}
		catch(Exception e) {
			return "Some Error Occured";
		}
	}
	public APIResponse getArticleLogic(List<Article> articles) {
		APIResponse apiResponse = new APIResponse();
		if(articles==null) {
			apiResponse.setStatus(404);
			apiResponse.setError("Not Found");
			apiResponse.setTitle("Empty");
		}
		ArticleData articleData = new ArticleData();
		articleData.setArticles(articles);
		apiResponse.setTitle("Articles");
		apiResponse.setData(articleData.getArticles());
		return apiResponse;
		
	}
	public APIResponse getArticles() {
		List<Article> articles = articleRepo.getArticles();
		return getArticleLogic(articles);
	}
	
	public APIResponse getArticles(boolean publish) {
		List<Article> articles = articleRepo.getArticles(publish);

		return getArticleLogic(articles);
	}
	
	
	
	public APIResponse getArticle(Article article) {
		APIResponse apiResponse = new APIResponse();
		if(article==null) {
			apiResponse.setStatus(404);
			apiResponse.setError("Not Found");
			apiResponse.setTitle("Page Not Found");
		}else {
			apiResponse.setTitle(article.getTitle());
			apiResponse.setData(article);
		}
		return apiResponse;
	}
	
	public APIResponse getApiArticleByUrl(String topic_url,String article_url,boolean publish) {
		Article article = articleRepo.getArticleByUrl(topic_url,article_url,publish);;
		return getArticle(article);
	}
	
	public APIResponse getApiArticleByUrl(String topic_url,String article_url) {
		Article article = articleRepo.getArticleByUrl(topic_url,article_url);;
		return getArticle(article);
	}
	
	
	public List<Article> getApiArticlesByTopic(Topic topic,boolean publish) {
		
		List<Article> articles = articleRepo.getArticlesByTopic(topic,publish);
		
		return articles;
	}
	
	public List<Article> getApiArticlesByTopic(Topic topic) {
		
		List<Article> articles = articleRepo.getArticlesByTopic(topic);
		
		return articles;
	}
	
	public APIResponse changePublishArticle(boolean publish, long articleId) {
		APIResponse apiResponse = new APIResponse();
		try {
			articleRepo.changePublishArticle(publish, articleId);
			apiResponse.setData("success");
		}catch(Exception e)
		{
			apiResponse.setData("error");
			apiResponse.setError("Error while Publish or Unpublish");
		}
		return apiResponse;
	}
	
	public APIResponse updateArticleHtml(String htmlBody, long articleId) {
		APIResponse apiResponse = new APIResponse();
		try {
			articleRepo.updateArticleHtml(htmlBody,DateTime.now(), articleId);
			apiResponse.setData("success");
		}catch(Exception e)
		{
			apiResponse.setData("error");
			apiResponse.setError("Error while Publish or Unpublish");
		}
		return apiResponse;
	}
	
}
