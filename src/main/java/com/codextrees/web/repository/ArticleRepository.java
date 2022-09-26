package com.codextrees.web.repository;

import com.codextrees.web.models.Article;
import com.codextrees.web.models.Topic;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.joda.time.DateTime;
public interface ArticleRepository extends CrudRepository<Article,Long> {
	
	@Query("Select a FROM Article a WHERE a.topic.url =:topic_url AND a.url = :article_url AND a.publish =:publish")
	 public Article getArticleByUrl(@Param("topic_url") String topic_url, @Param("article_url") String article_url, @Param("publish") boolean publish);
	
	@Query("Select a FROM Article a WHERE a.topic.url =:topic_url AND a.url = :article_url")
	 public Article getArticleByUrl(@Param("topic_url") String topic_url, @Param("article_url") String article_url);
	
	@Query("Select a FROM Article a WHERE a.publish =:publish")
	public List<Article> getArticles(@Param("publish") boolean publish);
	
	@Query("Select a FROM Article a")
	public List<Article> getArticles();
	
	@Query("Select a FROM Article a WHERE a.topic =:topic and a.publish =:publish")
	public List<Article> getArticlesByTopic(@Param("topic") Topic topic,@Param("publish") boolean publish);
	
	@Query("Select a FROM Article a WHERE a.topic =:topic")
	public List<Article> getArticlesByTopic(@Param("topic") Topic topic);
	
	@Transactional
	@Modifying
	@Query("UPDATE Article a set a.publish =?1  WHERE a.id = ?2")
	public void changePublishArticle(boolean publish, long articleId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Article a set a.htmlBody =?1 , a.updatedAt =?2  WHERE a.id = ?3")
	public void updateArticleHtml(String htmlBody, DateTime updatedAt,  long articleId);
	
	
}
