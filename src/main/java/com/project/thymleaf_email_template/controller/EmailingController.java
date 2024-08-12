package com.project.thymleaf_email_template.controller;

import com.project.thymleaf_email_template.dto.MailRequest;
import com.project.thymleaf_email_template.service.EmailingService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mail")
@AllArgsConstructor
public class EmailingController {
    private final EmailingService emailingService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void sendMail(@RequestBody MailRequest request) throws MessagingException {
        emailingService.sendMail(request);
    }
}
