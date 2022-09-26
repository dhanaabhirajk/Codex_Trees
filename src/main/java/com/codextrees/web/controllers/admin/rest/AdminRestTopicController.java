
package com.codextrees.web.controllers.admin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codextrees.web.common.APIResponse;
import com.codextrees.web.models.Topic;
import com.codextrees.web.service.TopicService;

@RestController
public class AdminRestTopicController {
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
		APIResponse apiResponse = topicService.getTopics(false);
		return apiResponse;
	}
	
	@RequestMapping("/api/t/{topic_url}")
	public APIResponse getTopic(@PathVariable("topic_url") String topic_url) {
		APIResponse apiResponse = topicService.getTopicByUrl(topic_url,false);
		return apiResponse;
	}
	
	@PostMapping("/admin/t/publish")
	@ResponseBody
	public APIResponse publishTopic(@RequestParam(value = "topicId",required = true) long topicId	) {
		APIResponse apiResponse = new APIResponse();
		apiResponse = topicService.changePublishTopic(true, topicId);
		if(apiResponse.getData().equals("success")) {
			apiResponse.setData("Published");
		}
		
		return apiResponse;
	}
	
	
	@PostMapping("/admin/t/unpublish")
	@ResponseBody
	public APIResponse unpublishTopic(@RequestParam(value = "topicId",required = true) long topicId	) {
		APIResponse apiResponse = new APIResponse();
		apiResponse = topicService.changePublishTopic(false, topicId);
		if(apiResponse.getData().equals("success")) {
			apiResponse.setData("Unpublished");
		}
		return apiResponse;
	}
	
}
