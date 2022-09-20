package com.codextrees.web.repository;

import com.codextrees.web.models.Article;
import com.codextrees.web.models.Topic;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends CrudRepository<Article,Long> {
	
	@Query("Select a FROM Article a WHERE a.topic.url =:topic_url AND a.url = :article_url")
	 public Article getArticleByUrl(@Param("topic_url") String topic_url, @Param("article_url") String article_url);
	
	@Query("Select a FROM Article a")
	public List<Article> getArticles();
	
	@Query("Select a FROM Article a WHERE a.topic =:topic")
	public List<Article> getArticlesByTopic(@Param("topic") Topic topic);
	
}
