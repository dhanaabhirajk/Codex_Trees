package com.codextrees.web.controllers.user.rest;



import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codextrees.web.service.UserService;

@RestController
public class UserRestHomeHomeController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/subscribe")
    public Map<String, Object> subscribe(@AuthenticationPrincipal OAuth2User principal) { 
		String result;
		try {
			userService.enableMailNotification(principal.getAttribute("email"));
			result =  "success";
		}catch(Exception e) {
			result =  e.getMessage();
		}
		return Collections.singletonMap("result", result);
    }
	
	@PostMapping("/unsubscribe")
    public Map<String, Object> unsubscribe(@AuthenticationPrincipal OAuth2User principal) { 
		String result;
		try {
			userService.disableMailNotification(principal.getAttribute("email"));
			result =  "success";
		}catch(Exception e) {
			result =  e.getMessage();
		}
		return Collections.singletonMap("result", result);
    }
	
}