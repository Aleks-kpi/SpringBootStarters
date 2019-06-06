package com.javadevjournal.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
public class JavaEmailService {

    private JavaMailSender mailSender;

    public JavaEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail() {
        MimeMessagePreparator messagePreparator = mimeMessage -> {

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom("noreply@www.javadevjournal.com");
            helper.setTo("xxx@gmail.com");
            helper.setSubject("Sample  mail subject");
            helper.setText("Test Email");
        };

        mailSender.send(messagePreparator);
    }
}
