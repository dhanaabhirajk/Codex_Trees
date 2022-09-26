package com.codextrees.web.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codextrees.web.service.UserService;


@RestController
public class RestHomeController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
    public HashMap<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		
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
	
}