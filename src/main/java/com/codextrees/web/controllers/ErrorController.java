package com.codextrees.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ErrorController {
	@RequestMapping("/accessdenied")
	public String accessDenied() {
		return "static/accessdenied.html";
	}
}
