package com.codextrees.web.repository;

import com.codextrees.web.models.Comment;
import com.codextrees.web.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends CrudRepository<Comment,Long> {
    @Query("update  Comment as c set c.comment_msg=?1 where c.comment_id=?2")
    public Comment getUserByUsername(String comment_msg, long comment_id);
}
