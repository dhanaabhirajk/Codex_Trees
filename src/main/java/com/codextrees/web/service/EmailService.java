package com.codextrees.web.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.codextrees.web.models.EmailDetails;
import com.codextrees.web.models.Post;
import com.codextrees.web.repository.UserRepository;

//Annotation
@Service
//Class
//Implementing EmailService interface
public class EmailService {

 @Autowired private JavaMailSender javaMailSender;
 
 @Autowired
 private UserRepository userRepository;
// @Autowired     
// private Configuration fmConfiguration;


 @Autowired
 private SpringTemplateEngine templateEngine;
 @Autowired
 private PostService postService;
 @Value("${spring.mail.username}") private String sender;

 // To send a simple email
 public String sendSimpleMail(EmailDetails details)
 {

     // Try block to check for exceptions
     try {

         // Creating a simple mail message
         SimpleMailMessage mailMessage
             = new SimpleMailMessage();

         // Setting up necessary details
         mailMessage.setFrom(sender);
         mailMessage.setTo(details.getRecipient());
         mailMessage.setText(details.getMsgBody());
         mailMessage.setSubject(details.getSubject());
         // Sending the mail
         javaMailSender.send(mailMessage);
         return "Mail Sent Successfully...";
     }

     // Catch block to handle the exceptions
     catch (Exception e) {
         return "Error while Sending Mail";
     }
 }


 public String sendMailAll(EmailDetails details){
    try {

        // Creating a simple mail message
        SimpleMailMessage mailMessage
            = new SimpleMailMessage();

        // Setting up necessary details
        mailMessage.setFrom(sender);
        mailMessage.setBcc(userRepository.getAllSubscribedUsernames());
        mailMessage.setText(details.getMsgBody());
        mailMessage.setSubject(details.getSubject());

        // Sending the mail
        javaMailSender.send(mailMessage);
        return "Mail Sent Successfully to all...";
    }

    // Catch block to handle the exceptions
    catch (Exception e) {
        return "Error while Sending Mail";
    }
 }
 
 
 
 
 
 
//Post
 //
 public String sendMailPost(EmailDetails details,boolean all)
 {
	 MimeMessage mimeMessage
     = javaMailSender.createMimeMessage();
 MimeMessageHelper mimeMessageHelper;

 try {
     mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
     mimeMessageHelper.setFrom(sender);
     if(all) {
    	 mimeMessageHelper.setBcc(userRepository.getAllSubscribedUsernames());
     }else {
    	 mimeMessageHelper.setTo(details.getRecipient());
     }
     
     Post post = postService.getLatestPost();
     HashMap<String,Object> model = new HashMap<>();
     model.put("postdetails", post);
     
     Context context = new Context();
     context.setVariables(model);
     String html = templateEngine.process("email/post_template", context);
     mimeMessageHelper.setText(html,true);
     //mimeMessageHelper.setText(geContentFromTemplate(model),true);
     mimeMessageHelper.setSubject(post.getTitle());

     javaMailSender.send(mimeMessage);
     return "success";
 }

 catch (Exception e) {
     return "Error while sending mail!!!";
 }
 }
 
// public String geContentFromTemplate(Map < String, Object >model)     { 
//     StringBuffer content = new StringBuffer();
//
//     try {
//         content.append(FreeMarkerTemplateUtils.processTemplateIntoString(fmConfiguration.getTemplate("email/post_template.flth"), model));
//     } catch (Exception e) {
//         e.printStackTrace();
//     }
//     return content.toString();
// }

 
 
 
 
 // To send an email with attachment
 public String
 sendMailWithAttachment(EmailDetails details)
 {
     // Creating a mime message
     MimeMessage mimeMessage
         = javaMailSender.createMimeMessage();
     MimeMessageHelper mimeMessageHelper;

     try {

         // Setting multipart as true for attachments to
         // be send
         mimeMessageHelper
             = new MimeMessageHelper(mimeMessage, true);
         mimeMessageHelper.setFrom(sender);
         mimeMessageHelper.setTo(details.getRecipient());
         mimeMessageHelper.setText(details.getMsgBody());
         mimeMessageHelper.setSubject(
             details.getSubject());

         // Adding the attachment
         FileSystemResource file
             = new FileSystemResource(
                 new File(details.getAttachment()));

         mimeMessageHelper.addAttachment(
             file.getFilename(), file);

         // Sending the mail
         javaMailSender.send(mimeMessage);
         return "Mail sent Successfully";
     }

     // Catch block to handle MessagingException
     catch (MessagingException e) {

         // Display message when exception occurred
         return "Error while sending mail!!!";
     }
 }
}