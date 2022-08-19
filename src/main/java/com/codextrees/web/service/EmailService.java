package com.codextrees.web.service;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.codextrees.web.models.EmailDetails;
import com.codextrees.web.repository.UserRepository;

//Annotation
@Service
//Class
//Implementing EmailService interface
public class EmailService {

 @Autowired private JavaMailSender javaMailSender;
 
 @Autowired
 private UserRepository userRepository;

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
        mailMessage.setCc(userRepository.getAllSubscribedUsernames());
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