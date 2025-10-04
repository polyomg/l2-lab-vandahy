package com.poly.lab8.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service("mailService")
public class L8_MailServiceImpl implements L8_MailService {


    @Autowired
    JavaMailSender mailSender;

    List<Mail> queue = new ArrayList<>();
    @Override
    public void push(Mail mail) {
        queue.add(mail);
    }
    @Scheduled(fixedRate = 500)
    public void run(){
        while(!queue.isEmpty()){
            try {
                this.send(queue.remove(0));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void send(Mail mail) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");


            helper.setFrom(mail.getFrom());
            helper.setReplyTo(mail.getFrom());

            helper.setTo(mail.getTo());
            if (!this.isNullOrEmpty(mail.getCc())){
                helper.setCc(mail.getCc());
            }
            if (!this.isNullOrEmpty(mail.getBcc())){
                helper.setBcc(mail.getBcc());
            }
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getBody(), true);

            String filenames = mail.getFileNames();
            if (!this.isNullOrEmpty(filenames)) {
                for (String filename : filenames.split("[,;]+")) {
                    File file = new File(filename.trim());
                    helper.addAttachment(file.getName(), file);
                }
            }
            mailSender.send(mimeMessage);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public boolean isNullOrEmpty(String text){
        return text == null || text.trim().isEmpty();
    }
}
