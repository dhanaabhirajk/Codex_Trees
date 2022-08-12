package com.codextrees.web;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestHomeController {
	@GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
	
	@GetMapping("/error")
	public String error(HttpServletRequest request) {
		String message = (String) request.getSession().getAttribute("error.message");
		request.getSession().removeAttribute("error.message");
		return message;
	}
	
	@Autowired
	private UserService userService;
	@GetMapping("/subscribe")
    public String subscribe(@AuthenticationPrincipal OAuth2User principal) { 
		try {
			userService.enableMailNotification(principal.getAttribute("email"));
			return "success";
		}catch(Exception e) {
			return e.getMessage();
		}
		
    }
}