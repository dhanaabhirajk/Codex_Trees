package com.codextrees.web.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codextrees.web.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
   
   @Query("SELECT u FROM User u WHERE u.username = :username")
   public User getUserByUsername(@Param("username") String username);
   //in sqlite bool is 1
   @Query("SELECT u.username FROM User u WHERE u.enabled = true")
   public String[] getAllSubscribedUsernames();

   @Transactional
   @Modifying
   @Query("update User u set u.enabled = ?1 where u.id = ?2")
   void changeMailNotification(boolean enable, Long userId);
}