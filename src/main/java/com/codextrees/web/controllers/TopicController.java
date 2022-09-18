package com.codextrees.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codextrees.web.common.APIResponse;
import com.codextrees.web.models.Topic;
import com.codextrees.web.service.TopicService;

@RestController
public class TopicController {
	@Autowired
	TopicService topicService;
	
	
	@PostMapping("/admin/createtopic")
	@ResponseBody
	public String createArticle(@ModelAttribute("topicdetails") Topic topic) {
		
		String status = topicService.createTopic(topic);
		return status;
	}
	
	//api for all topics
	@RequestMapping("/api/topic/all")
	public APIResponse getTopics() {
		APIResponse apiResponse = topicService.getTopics();
		return apiResponse;
	}
	
	@RequestMapping("/api/t/{topic_url}")
	public APIResponse getTopic(@PathVariable("topic_url") String topic_url) {
		APIResponse apiResponse = topicService.getTopicByUrl(topic_url);
		return apiResponse;
	}
	
	
}
