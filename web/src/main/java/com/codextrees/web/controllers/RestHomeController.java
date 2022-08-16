package com.codextrees.web.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codextrees.web.service.UserService;


@RestController
public class RestHomeController {
	@GetMapping("/user")
    public HashMap<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		if(! (boolean) principal.getAttribute("name")){
			return null;
		}
		HashMap<String,Object> map = new HashMap<>();
		map.put("name", principal.getAttribute("name"));
		map.put("user",userService.loadUserByUsername(principal.getAttribute("email")));
		
        return map;
    }
	
	@GetMapping("/error")
	public String error(HttpServletRequest request) {
		String message = (String) request.getSession().getAttribute("error.message");
		request.getSession().removeAttribute("error.message");
		return message;
	}
	
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