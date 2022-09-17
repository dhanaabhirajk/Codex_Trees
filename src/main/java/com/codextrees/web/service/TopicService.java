package com.codextrees.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codextrees.web.models.Topic;
import com.codextrees.web.repository.TopicRepository;

@Component
public class TopicService {
	@Autowired
	private TopicRepository topicRepo;
	public String createTopic(Topic topic) {
		try {
			topicRepo.save(topic);
			return "Topic Added";
		}
		catch(Exception e) {
			return "Some Error Occured";
		}
	}
}
