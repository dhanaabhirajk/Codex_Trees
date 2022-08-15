package com.codextrees.web.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codextrees.web.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
   
   @Query("SELECT u FROM User u WHERE u.username = :username")
   public User getUserByUsername(@Param("username") String username);
   
   @Query("SELECT u.username FROM User u WHERE u.enabled = 1")
   public String[] getAllSubscribedUsernames();

   @Transactional
   @Modifying
   @Query("update User u set u.enabled = ?1 where u.id = ?2")
   void changeMailNotification(boolean enable, Long userId);
}