package com.codextrees.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codextrees.web.dto.CommentDTO;
import com.codextrees.web.dto.PostDTO;
import com.codextrees.web.models.Comment;
import com.codextrees.web.models.Post;
import com.codextrees.web.models.User;
import com.codextrees.web.repository.PostRepository;

@Component
public class PostService {
	@Autowired
	private PostRepository postRepo;
	
	public String createPost(Post post) {
		try {
			postRepo.save(post);
			return "Post Added";
		}
		catch(Exception e) {
			return "Some Error Occured";
		}
	}
	
	public Post getLatestPost() {
		return postRepo.getLatestPost();
	}
	
	public List<Post> getPosts() {
		return postRepo.getPosts();
	}
	public Post getPostById(long post_id) {
		return postRepo.getPostById(post_id);
	}
	
	public PostDTO getLatestPostDTO(boolean commentData) {
		Post post;
		List<Comment> commentList = null;
		
		
		post = postRepo.getLatestPost();
		if(commentData) {
			commentList = post.getComments();
		}
		
		PostDTO postDTO = new PostDTO();
		postDTO.setId(post.getId());
		postDTO.setImage_link(post.getImage_link());
		postDTO.setTitle(post.getTitle());
		postDTO.setMsgBody(post.getMsgBody());
		postDTO.setLink(post.getLink());
		postDTO.setCreatedAt(post.getCreatedAt());
		
		List<CommentDTO> commentDTOList = new ArrayList<CommentDTO>();
		if(commentList!=null) {
			for(Comment comment : commentList) {
				CommentDTO commentDTO = new CommentDTO();
				commentDTO.setId(comment.getId());
				commentDTO.setMsgBody(comment.getMsgBody());
				commentDTO.setUsername(comment.getUser().getName());
				commentDTO.setCreatedAt(comment.getCreatedAt());
				commentDTOList.add(commentDTO);
			}
			postDTO.setComments(commentDTOList);
		}
		
		return postDTO;
	}
}
