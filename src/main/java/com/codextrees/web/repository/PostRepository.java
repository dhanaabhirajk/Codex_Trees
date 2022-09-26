package com.codextrees.web.repository;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codextrees.web.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

	//need to check SQL injection
   
   @Query("SELECT p FROM Post p WHERE p.createdAt = :date")
   public Post getPostByDate(@Param("date") DateTime date);

   //used native query so p is not used and column name is created_at as in table
   @Query(value = "SELECT * FROM Post ORDER BY created_at DESC LIMIT 1",nativeQuery = true)
   public Post getLatestPost();
   
   @Query("Select p FROM Post p WHERE p.id = :post_id")
   public Post getPostById(@Param("post_id") long post_id);
   
   @Query("SELECT p FROM Post p")
	public List<Post> getPosts();
}
