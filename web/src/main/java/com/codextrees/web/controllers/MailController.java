package com.codextrees.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codextrees.web.models.EmailDetails;
import com.codextrees.web.service.EmailService;

@Controller
public class MailController {
	
	
	@Autowired private EmailService emailService;
	
	@RequestMapping("/sendmail")
	public String sendSimpleMailForm(Model model) {
		 model.addAttribute("details", new EmailDetails());
		return "sendMail";
	}
	@PostMapping("/sendmail")
    @ResponseBody
    public String sendSimpleMail(@ModelAttribute("details") EmailDetails details){
		String status = emailService.sendSimpleMail(details);
		return status;

    }
	
	@RequestMapping("/sendmailall")
	public String sendSimpleMailAllForm(Model model) {
		 model.addAttribute("details", new EmailDetails());
		return "sendMailAll";
	}
	@PostMapping("/sendmailall")
    @ResponseBody
    public String sendMailAll(@ModelAttribute("details") EmailDetails details){
		String status = emailService.sendMailAll(details);
		return status;

    }
	
//	@RequestMapping("/sendmailwithattachment")
//	public String sendMailWithAttachmentMailForm(Model model) {
//		 model.addAttribute("details", new EmailDetails());
//		return "sendMailWithAttachment";
//	}
	
//	@PostMapping("/sendmailwithattachment")
//    @ResponseBody
//    public String sendMailWithAttachment(@ModelAttribute("details") EmailDetails details,@RequestParam("attachment") MultipartFile file,RedirectAttributes redirectAttributes){
//		storageService.store(file);
//		redirectAttributes.addFlashAttribute("message",
//				"You successfully uploaded " + file.getOriginalFilename() + "!");
//		String status = emailService.sendMailWithAttachment(details);
//		return status;
//
//    }
	
}