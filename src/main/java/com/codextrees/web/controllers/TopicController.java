package com.codextrees.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
