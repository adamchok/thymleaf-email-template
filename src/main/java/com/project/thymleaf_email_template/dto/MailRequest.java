package com.project.thymleaf_email_template.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MailRequest {
    @JsonAlias(value = "to_email")
    private String toEmail;

    private String subject;

    private String message;

    @JsonAlias(value = "html")
    private boolean isHTML;
}
