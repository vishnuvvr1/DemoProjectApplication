package com.java.vishnu.DemoProject.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
public void  SendMail(String toEmail,
                      String subject,
                      String body){
    SimpleMailMessage message= new SimpleMailMessage();
    message.setFrom("vishnuvvr8919@gmail.com");
    message.setTo(toEmail);
    message.setText(body);
    message.setSubject(subject);
    mailSender.send(message);
    System.out.println("mail send successfully.....");
}
}