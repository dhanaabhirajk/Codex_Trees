package com.codextrees.web.models;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @JoinColumn(name = "id",referencedColumnName = "user_id",nullable = false)
    private long user_id;
//    private long post_id;
    private String comment_msg;

    private DateTime createdAt;
    private DateTime updatedAt;

    public long getId() {
        return id;
    }

    public long getUser_id() {
        return user_id;
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

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getComment_msg() {
        return comment_msg;
    }

    public void setComment_msg(String comment_msg) {
        this.comment_msg = comment_msg;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
