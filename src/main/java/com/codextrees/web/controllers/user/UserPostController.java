package com.codextrees.web.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codextrees.web.dto.PostDTO;
import com.codextrees.web.models.Comment;
import com.codextrees.web.models.Post;
import com.codextrees.web.service.PostService;

@Controller
public class UserPostController {
	@Autowired 
	private PostService postService;
	
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
