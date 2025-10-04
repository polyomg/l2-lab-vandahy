package com.poly.lab8.service;

import lombok.Builder;
import lombok.Data;

public interface L8_MailService {
    @Data
    @Builder
    public static class Mail{
        @Builder.Default
        private String from = "Webshop <vandahy77@gmail.com>";
        private String to, cc, bcc, subject, body, fileNames;
    }
    void send(Mail mail);
    default void send(String to, String subject, String body){
        Mail mail = Mail.builder().to(to).subject(subject).body(body).build();
        this.send(mail);
    }
    void push(Mail mail);
    default void push(String to, String subject, String body){
        this.push(Mail.builder().to(to).subject(subject).body(body).build());
    }
}
