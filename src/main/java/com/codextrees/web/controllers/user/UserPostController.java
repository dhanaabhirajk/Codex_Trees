package com.codextrees.web.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codextrees.web.dto.PostDTO;
import com.codextrees.web.models.Comment;
import com.codextrees.web.models.Post;
import com.codextrees.web.service.PostService;

@Controller
public class UserPostController {
	@Autowired 
	private PostService postService;
	
	@RequestMapping("/latestpost")
	public String getLatestPost(Model model) {
		PostDTO post = postService.getLatestPostDTO(true);
		model.addAttribute("postdetails", post);
		Comment comment = new Comment();
		//comment.setPost(post);
		model.addAttribute("commentdetails", comment);
		model.addAttribute("pageTitle","Latest Post");	
		return "post/newlatestpost";
	}
	@RequestMapping("/p/{post_url}")
	public String getPost(Model model, @PathVariable("post_url") String post_url) {
		PostDTO post = postService.getPostDTOById(post_url,true);
		model.addAttribute("postdetails", post);
		Comment comment = new Comment();
		//comment.setPost(post);
		model.addAttribute("commentdetails", comment);
		model.addAttribute("pageTitle",post.getTitle());	
		return "post/newlatestpost";
	}
	
	@RequestMapping("/posts")	
	public String getPosts(Model model) {
		List<Post> posts= postService.getPosts();
		model.addAttribute("posts", posts);
		model.addAttribute("pageTitle","Posts");	
		return "post/allposts";
	}
	
}
