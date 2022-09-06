package com.codextrees.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codextrees.web.models.Comment;

@Controller
public class CLangController {

	@RequestMapping("/c-lang/{topic}")
	public String getCLangTopic(@PathVariable("") String topic) {
		return "c_lang/html/"+topic+".html";
	}
}
