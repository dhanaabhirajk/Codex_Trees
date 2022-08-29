package com.codextrees.web.models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
public class Comment {

	@Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id",nullable = false)
    private User user;
    
    @Column(columnDefinition="TEXT")
    private String msgBody;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdAt;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedAt;
    
    @ManyToOne
    @JoinColumn(name = "post_id",referencedColumnName = "post_id",nullable = false)
    private Post post;
    
    public Post getPost() {
		return post;
	}


	public void setPost(Post post) {
		this.post = post;
	}


	public String getMsgBody() {
		return msgBody;
	}


	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}


    
    public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
    

    public long getId() {
        return id;
    }


    public DateTime getCreatedAt() {
        return createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

   

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
