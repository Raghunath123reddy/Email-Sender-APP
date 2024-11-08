package com.example.emailservice.Email.Service;

import com.example.emailservice.Email.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/sendEmail")
    public String sendEmail(@RequestParam String to,
                            @RequestParam String subject,
                            @RequestParam String body) {
        try {
            emailService.sendSimpleEmail(to, subject, body);
            return "Email sent successfully to " + to;
        } catch (Exception e) {
            // Print detailed error log for debugging
            e.printStackTrace();
            return "Failed to send email. Error: " + e.getMessage();
        }
    }
}
