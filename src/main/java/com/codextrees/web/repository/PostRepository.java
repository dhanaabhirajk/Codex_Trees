package com.codextrees.web.repository;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codextrees.web.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

   
   @Query("SELECT p FROM Post p WHERE p.createdAt = :date")
   public Post getPostById(@Param("date") DateTime date);

   @Query("SELECT p FROM Post p ORDER BY u.createdAt DESC")
   public Post getLatestPost();
}