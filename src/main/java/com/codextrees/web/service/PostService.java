package com.codextrees.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codextrees.web.models.Post;
import com.codextrees.web.repository.PostRepository;

@Component
public class PostService {
	@Autowired
	private PostRepository postRepo;
	
	public String createPost(Post post) {
		try {
			postRepo.save(post);
			return "success";
		}
		catch(Exception e) {
			return "not success"+e.getMessage();
		}
	}
	
	public Post getLatestPost() {
		return postRepo.getLatestPost();
	}
}
