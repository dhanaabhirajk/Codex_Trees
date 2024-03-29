package com.codextrees.web.controllers.user;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codextrees.web.common.APIResponse;
import com.codextrees.web.service.TopicService;

@Controller
public class UserTopicController {
	@Autowired
	TopicService topicService;
	
	//all topics templates
	@RequestMapping("/topics")
	public String getAllTopics(HttpServletResponse response,Model model) {
		APIResponse apiResponse = topicService.getTopics(true);
		response.setStatus(apiResponse.getStatus());
		model.addAttribute("topics",apiResponse.getData());
		model.addAttribute("pageTitle","Topics");	
		return "topic/topics";
	}
	
	
	@RequestMapping("/t/{topic_url}")
	public String getTopic(HttpServletResponse response,Model model, @PathVariable("topic_url") String topic_url) {
		APIResponse apiResponse = topicService.getTopicByUrl(topic_url,true);
		response.setStatus(apiResponse.getStatus());
		model.addAttribute("topicArticle",apiResponse.getData());
		model.addAttribute("pageTitle",apiResponse.getTitle());	
		return "topic/topic";
	}
	
}
