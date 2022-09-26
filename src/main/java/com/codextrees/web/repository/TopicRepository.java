package com.codextrees.web.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codextrees.web.models.Topic;

public interface TopicRepository extends CrudRepository<Topic,Long> {
	
	@Query("SELECT t FROM Topic t")
	public List<Topic> getAllTopics();
	
	@Query("SELECT t FROM Topic t WHERE t.publish =:publish")
	public List<Topic> getTopics(@Param("publish") boolean publish);
	
	@Query("SELECT t FROM Topic t WHERE t.url =:url and t.publish =:publish")
	public Topic getTopic(@Param("url") String url,@Param("publish") boolean publish);

	@Query("SELECT t FROM Topic t WHERE t.url =:url")
	public Topic getTopic(@Param("url") String url);
	
	@Transactional
	@Modifying
	@Query("UPDATE Topic t set t.publish =?1  WHERE t.id = ?2")
	public void changePublishTopic(boolean publish, long topicId);
	
}
