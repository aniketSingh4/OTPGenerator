package com.otp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailUtil {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOtpEmail(String toEmail, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your-email@gmail.com"); // Your email
        message.setTo(toEmail);
        message.setSubject("Your OTP for Account Verification");
        message.setText("Your OTP is: " + otp);

        mailSender.send(message);
        System.out.println("OTP sent successfully to " + toEmail);
    }
}
