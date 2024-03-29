package com.codextrees.web.controllers.admin;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codextrees.web.common.APIResponse;
import com.codextrees.web.service.TopicService;

@Controller
@RequestMapping("/admin/")
public class AdminTopicController {
	@Autowired
	TopicService topicService;
	
	//all topics templates
	@RequestMapping("/topics")
	public String getAllTopics(HttpServletResponse response,Model model) {
		APIResponse apiResponse = topicService.getTopics();
		response.setStatus(apiResponse.getStatus());
		model.addAttribute("topics",apiResponse.getData());
		model.addAttribute("pageTitle","Topics");	
		return "admin/topic/topics";
	}
		
	
	@RequestMapping("/t/{topic_url}")
	public String getTopic(HttpServletResponse response,Model model, @PathVariable("topic_url") String topic_url) {
		APIResponse apiResponse = topicService.getTopicByUrl(topic_url);
		response.setStatus(apiResponse.getStatus());
		model.addAttribute("topicArticle",apiResponse.getData());
		model.addAttribute("pageTitle",apiResponse.getTitle());	
		return "admin/topic/topic";
	}
	
	
}
