package com.codextrees.web.controllers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codextrees.web.models.Comment;
import com.codextrees.web.service.CommentService;
import com.codextrees.web.service.PostService;
import com.codextrees.web.service.UserService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	
 	@PostMapping("/comment/createcomment")
 	@ResponseBody
 	public String user(@AuthenticationPrincipal OAuth2User principal, @ModelAttribute("commentdetails") Comment comment, @RequestParam(value = "postId",required = true) long postId	) {
 		comment.setUser(userService.getUser(principal.getAttribute("email")));
 		comment.setCreatedAt(DateTime.now());
		comment.setUpdatedAt(DateTime.now());
		comment.setPost(postService.getPostById(postId));
		String status = commentService.createComment(comment);
        return status;
    }
 	
 	@RequestMapping("/comment/createcomment")
	public String createCommentForm(Model model) {
		model.addAttribute("commentdetails", new Comment());
		return "comment/createcomment";
	}
 	

//	@RequestMapping("/comment/getcomments")
//	public String getPosts(Model model) {
//		List<Comment> comments= commentService.getComments();
//		model.addAttribute("commentss", comments);
//		return "comment/allcomments";
//	}
}
