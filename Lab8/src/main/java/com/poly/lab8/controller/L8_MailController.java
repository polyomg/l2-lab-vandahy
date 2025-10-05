package com.poly.lab8.controller;

import com.poly.lab8.service.L8_MailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mail")
public class L8_MailController {
    @Autowired
    L8_MailService mailService;

    @GetMapping("/form")
    public String form(){
        return "lab8/send-mail";
    }
    @ResponseBody
    @PostMapping("/send")
    public String send(
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("body") String body
    ) {
        mailService.send(to, subject, body);
        return "Mail đã được gửi đi";

    }

    @ResponseBody
    @PostMapping("/push")
    public String push(
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("body") String body
    ) {
        mailService.push(to, subject, body);
        return "Mail đã thêm vào hàng chờ";
    }

}
