package com.project.thymleaf_email_template.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.project.thymleaf_email_template.model.User;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MailRequest {
    @JsonAlias(value = "to_email")
    private String toEmail;

    @JsonAlias(value = "subject")
    private String subject;

    @JsonAlias(value = "user")
    private User user;

    @JsonAlias(value = "html")
    private boolean isHTML;
}
