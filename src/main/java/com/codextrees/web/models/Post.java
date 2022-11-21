package com.codextrees.web.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class Post {
	@Id
	@Column(name = "post_id")
	private String id;
	private String title;
	private String link;
	private String link_title;
	@Column(columnDefinition="TEXT")
	private String msgBody;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdAt;
	public String getLink_title() {
		return link_title;
	}
		
	public void setLink_title(String link_title) {
		this.link_title = link_title;
	}

	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedAt;
	private String image_link;
	
	
	@OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<Comment>();
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public DateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	
	
	
}
