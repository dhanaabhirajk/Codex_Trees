package com.codextrees.web.controllers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codextrees.web.models.Post;
import com.codextrees.web.service.PostService;

@Controller
public class PostController {
	@Autowired 
	private PostService postService;
	
	@RequestMapping("/post/latestpost")
	public String getLatestPost(Model model) {
		Post post = postService.getLatestPost();
		model.addAttribute("postdetails", post);
		return "post/latestpost";
	}
	
	@RequestMapping("/post/createpost")
	public String createPostForm(Model model) {
		model.addAttribute("postdetails", new Post());
		return "post/createpost";
	}
	
	@PostMapping("/post/createpost")
	@ResponseBody
	public String createPost(@ModelAttribute("postdetails") Post post) {
		post.setCreatedAt(DateTime.now());
		System.out.println(DateTime.now());
		post.setUpdatedAt(DateTime.now());
		String status = postService.createPost(post);
		return status;
	}
	
}
