package com.codextrees.web.controllers;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codextrees.web.dto.PostDTO;
import com.codextrees.web.models.Comment;
import com.codextrees.web.models.Post;
import com.codextrees.web.service.PostService;

@Controller
public class PostController {
	@Autowired 
	private PostService postService;
	
	
	
	@RequestMapping("/admin/createpost")
	public String createPostForm(Model model) {
		model.addAttribute("postdetails", new Post());
		return "admin/createpost";
	}
	
	@PostMapping("/admin/createpost")
	@ResponseBody
	public String createPost(@ModelAttribute("postdetails") Post post) {
		post.setCreatedAt(DateTime.now());
		post.setUpdatedAt(DateTime.now());
		String status = postService.createPost(post);
		return status;
	}
	
	@RequestMapping("/post/latestpost")
	public String getLatestPost(Model model) {
		PostDTO post = postService.getLatestPostDTO(true);
		model.addAttribute("postdetails", post);
		Comment comment = new Comment();
		//comment.setPost(post);
		model.addAttribute("commentdetails", comment);
		return "post/newlatestpost";
	}
	
	@RequestMapping("/post/getposts")
	public String getPosts(Model model) {
		List<Post> posts= postService.getPosts();
		model.addAttribute("posts", posts);
		return "post/allposts";
	}
	
}
