package com.poly.lab8.controller;

import com.poly.lab8.entity.Account;
import com.poly.lab8.service.L8_AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class L8_AuthController {
    @Autowired
    L8_AccountService accountService;
    @Autowired
    HttpSession session;

    @GetMapping("/auth/login")
    public String loginForm(){
        return "lab8/login";
    }
    @PostMapping("/auth/login")
    public String login(
            Model model,
            @RequestParam("username") String username,
            @RequestParam("password") String password){
        Account user = accountService.findById(username);
        if(user == null){
            model.addAttribute("message", "Invalid username");
            return  "lab8/login";
        }else if (!user.getPassword().equals(password)){
            model.addAttribute("message", "Invalid password");
            return  "lab8/login";
        }else {

            session.setAttribute("user", user);
            model.addAttribute("message", "Login successful");
            String securityUri = (String)session.getAttribute("securityUri");
            if(securityUri != null) {
                session.removeAttribute("securityUri"); //after used, remove to avoid redirect again
                return "redirect:" + securityUri;
            }
            return "redirect:/mail/form";
        }
    }
}
