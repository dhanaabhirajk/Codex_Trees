package com.codextrees.web.data;

import java.util.List;

import com.codextrees.web.dto.ArticleDTO;
import com.codextrees.web.models.Topic;

public class TopicArticleData {
	private Topic topic;
	private List<ArticleDTO> articles;
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public List<ArticleDTO> getArticles() {
		return articles;
	}
	public void setArticles(List<ArticleDTO> articles) {
		this.articles = articles;
	}
}
