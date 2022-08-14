package com.codextrees.mail.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codextrees.web.EmailDetails;
import com.codextrees.web.EmailService;

@Controller	
public class RestMailController {

	@Autowired private EmailService emailService;
	 
    // Sending a simple Email
//
//	
//    @PostMapping("/sendMail")
//    
//    public String sendMail(@ModelAttribute("details") EmailDetails details)
//    {
//    	System.out.println(details.getRecipient());
//        String status
//            = emailService.sendSimpleMail(details);	
// 
//        return status;
//    }
 
    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
        @RequestBody EmailDetails details)
    {
        String status
            = emailService.sendMailWithAttachment(details);
 
        return status;
    }
}
