package com.project.thymleaf_email_template.service;

import com.project.thymleaf_email_template.dto.MailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class EmailingService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String fromMail;

    @Async
    public void sendMail(MailRequest request) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom(fromMail);
        mimeMessageHelper.setTo(request.getToEmail());
        mimeMessageHelper.setSubject(request.getSubject());

        if (request.isHTML()) {
            Context context = new Context();
            context.setVariable("user", request.getUser());
            String processedString = templateEngine.process("template", context);
            mimeMessageHelper.setText(processedString,true);

            ClassPathResource logo = new ClassPathResource("static/images/logo.jpg");
            mimeMessageHelper.addInline("logoCid", logo);
        } else {
            mimeMessageHelper.setText("No name", false);
        }
        mailSender.send(mimeMessage);
    }
}
