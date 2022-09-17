package com.codextrees.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codextrees.web.models.Comment;

public interface CommentRepository extends CrudRepository<Comment,Long> {
	
	@Query("SELECT c FROM Comment c")
	public List<Comment> getComments();
	
//	@Transactional
//	@Modifying
//    @Query("update  Comment c set c.comment_msg=?1 where c.comment_id=?2")
//    public Comment updateCommentbyId(String comment_msg, long comment_id);
}
