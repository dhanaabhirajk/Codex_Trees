package com.codextrees.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codextrees.web.common.APIResponse;
import com.codextrees.web.data.TopicArticleData;
import com.codextrees.web.data.TopicData;
import com.codextrees.web.dto.ArticleDTO;
import com.codextrees.web.models.Article;
import com.codextrees.web.models.Topic;
import com.codextrees.web.repository.ArticleRepository;
import com.codextrees.web.repository.TopicRepository;

@Component
public class TopicService {
	@Autowired
	private TopicRepository topicRepo;
	
	@Autowired
	private ArticleService articleService;
	public String createTopic(Topic topic) {
		try {
			topicRepo.save(topic);
			return "Topic Added";
		}
		catch(Exception e) {
			return "Some Error Occured";
		}
	}
		
	public APIResponse getTopics() {
		APIResponse apiResponse = new APIResponse();
		List<Topic> topics = topicRepo.getTopics();
		if(topics==null) {
			apiResponse.setStatus(404);
			apiResponse.setError("Not Found");
		}
		
		apiResponse.setData(topics);
		return apiResponse;
	}
	
	public APIResponse getTopicByUrl(String url) {
		APIResponse apiResponse = new APIResponse();
		Topic topic = topicRepo.getTopic(url);
		if(topic==null) {
			apiResponse.setStatus(404);
			apiResponse.setError("Not Found");
		}
		else {
			TopicArticleData topicArticleData = new TopicArticleData();
			topicArticleData.setTopic(topic);
			
			List<Article> articles = articleService.getApiArticlesByTopic(topic);
			if(articles==null) {
				apiResponse.setError("Empty");
			}
			else {
				List<ArticleDTO> articleDTOList = new ArrayList<ArticleDTO>();
				for(Article article : articles) {
					ArticleDTO articleDTO = new ArticleDTO();
					articleDTO.setId(article.getId());
					articleDTO.setTitle(article.getTitle());
					articleDTO.setDes(article.getDes());
					articleDTO.setUrl(article.getUrl());
					articleDTO.setCreatedAt(article.getCreatedAt());
					articleDTOList.add(articleDTO);
				}
				topicArticleData.setArticles(articleDTOList);
			}
			apiResponse.setData(topicArticleData);
		}
		
		return apiResponse;
	}
	
}
