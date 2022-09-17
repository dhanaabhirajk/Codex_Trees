package com.codextrees.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codextrees.web.models.Topic;

public interface TopicRepository extends CrudRepository<Topic,Long> {
	
	@Query("SELECT t FROM Topic t")
	public List<Topic> getTopics();
	
}
