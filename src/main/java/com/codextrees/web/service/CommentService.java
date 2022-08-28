package com.codextrees.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codextrees.web.models.Comment;
import com.codextrees.web.models.Post;
import com.codextrees.web.repository.CommentRepository;

@Component
public class CommentService {
	@Autowired
	private CommentRepository commentRepo;

	
	public String createComment(Comment comment) {
		try {
			commentRepo.save(comment);
			return "Comment Added";
		}
		catch(Exception e) {
			return "Some error occured";
		}
	}
	
	public List<Comment> getComments() {
		return commentRepo.getComments();
	}


}
