package com.codextrees.web.repository;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codextrees.web.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

   
   @Query("SELECT p FROM Post p WHERE p.createdAt = :date")
   public Post getPostByDate(@Param("date") DateTime date);

   //used native query so p is not used and column name is created_at as in table
   @Query(value = "SELECT * FROM Post ORDER BY created_at DESC LIMIT 1",nativeQuery = true)
   public Post getLatestPost();
}