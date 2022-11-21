package com.codextrees.web.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codextrees.web.dto.CommentDTO;
import com.codextrees.web.dto.PostDTO;
import com.codextrees.web.models.Comment;
import com.codextrees.web.models.Post;
import com.codextrees.web.repository.PostRepository;

@Component
public class PostService {
	@Autowired
	private PostRepository postRepo;
	
	public String createPost(Post post) {
		try {
			try {
				Document doc = Jsoup.connect(post.getLink()).get();
				post.setLink_title(doc.title());
			} catch (IOException e) {
				post.setLink_title(post.getTitle());
			}
			postRepo.save(post);
			return "Post Added";
		}
		catch(Exception e) {
			return "Some Error Occured";
		}
	}
	public Post getPostById(String post_id) {
		return postRepo.getPostById(post_id); 
	}
	public Post getLatestPost() {
		return postRepo.getLatestPost();
	}
	public PostDTO getLatestPostDTO(boolean commentData) {
		return getPostDTO(postRepo.getLatestPost(),commentData);
	}
	
	public PostDTO getPostDTOById(String post_id,boolean commentData) {
		return getPostDTO(postRepo.getPostById(post_id),commentData);
	}

	public List<Post> getPosts() {
		return postRepo.getPosts();
	}
	
	public PostDTO getPostDTO(Post post,boolean commentData) {
		
		List<Comment> commentList = null;
		if(commentData) {
			commentList = post.getComments();
		}
		
		
		List<CommentDTO> commentDTOList = null;
		if(commentList!=null) {
			commentDTOList = new ArrayList<CommentDTO>();
			for(Comment comment : commentList) {
				CommentDTO commentDTO = new CommentDTO();
				commentDTO.setId(comment.getId());
				commentDTO.setMsgBody(comment.getMsgBody());
				commentDTO.setUsername(comment.getUser().getName());
				commentDTO.setCreatedAt(comment.getCreatedAt());
				commentDTOList.add(commentDTO);
			}
		}
		
		PostDTO postDTO = new PostDTO(post.getId(),post.getTitle(),post.getLink(),post.getLink_title(),post.getMsgBody(),post.getCreatedAt(),post.getImage_link(),commentDTOList);
		return postDTO;
	}
}
