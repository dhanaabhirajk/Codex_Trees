package com.codextrees.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codextrees.web.models.Article;
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
	
	public Article getPostByUrl(String article_url) {
		return articleRepo.getArticleByUrl(article_url);
	}
	
}
