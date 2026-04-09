package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

```
@Autowired
private JavaMailSender mailSender;

public void sendDeploymentEmail() {

    try {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("ishikagujjar21@gmail.com");

        message.setSubject("Deployment Successful");

        message.setText(
                "Your application was deployed successfully at "
                        + LocalDateTime.now()
        );

        mailSender.send(message);

        System.out.println("Email sent successfully");

    } catch (Exception e) {

        // This prevents 500 error if email fails
        System.out.println("Email failed but deployment continues");

        e.printStackTrace();

    }

}
```

}
