package com.codextrees.web.dto;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;


public class PostDTO {
	private String id;
	private String title;
	private String link;
	private String link_title;
	private String msgBody;
	private DateTime createdAt;
	private String image_link;
	private List<CommentDTO> comments = new ArrayList<CommentDTO>();
	
	public PostDTO() {
		
	}
	public PostDTO(String id, String title, String link, String link_title, String msgBody, DateTime createdAt,
			String image_link, List<CommentDTO> comments) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.link_title = link_title;
		this.msgBody = msgBody;
		this.createdAt = createdAt;
		this.image_link = image_link;
		this.comments = comments;
	}

	public String getLink_title() {
		return link_title;
	}

	public void setLink_title(String link_title) {
		this.link_title = link_title;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

	
}
