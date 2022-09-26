package com.codextrees.web.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topic {
	@Id
	@Column(name = "topic_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String url;
	private String des;
	private boolean publish;
	public Long getId() {
		return id;
	}
	public boolean isPublish() {
		return publish;
	}
	public void setPublish(boolean publish) {
		this.publish = publish;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
	

//	public List<Article> getArticles() {
//		return articles;
//	}
//
//	public void setArticles(List<Article> articles) {
//		this.articles = articles;
//	}
//
//	@OneToMany(mappedBy = "topic",fetch = FetchType.LAZY)
//	private List<Article> articles = new ArrayList<Article>();
	
}
