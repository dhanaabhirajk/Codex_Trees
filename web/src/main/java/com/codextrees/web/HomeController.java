package com.codextrees.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@Autowired private EmailService emailService;
	
	@RequestMapping("/sendMail")
	public String sendMailForm(Model model) {
		 model.addAttribute("details", new EmailDetails());
		return "sendMail";
	}
	@RequestMapping(value = {"/sendMail"},method = RequestMethod.POST)
    @ResponseBody
    public String formModel(@ModelAttribute("details") EmailDetails details){
		String status = emailService.sendSimpleMail(details);
		return status;

    }
}