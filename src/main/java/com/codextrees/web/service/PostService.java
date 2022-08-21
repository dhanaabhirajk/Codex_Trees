package com.codextrees.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codextrees.web.models.Post;
import com.codextrees.web.repository.PostRepository;

@Component
public class PostService {
	@Autowired
	private PostRepository postRepo;
	
	public void processPost(Post post) {
		postRepo.save(post);
	}
	
	public Post getLatestPost(Long id) {
		return postRepo.getLatestPost();
	}
}
