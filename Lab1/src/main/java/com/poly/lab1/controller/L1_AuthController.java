package com.poly.lab1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class L1_AuthController {
    @Autowired
    private HttpServletRequest req;

    @RequestMapping("/form")
    public String form(){
        return "login";
    }

    @RequestMapping("/check")
    public String login(Model model){
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean isValid = "poly".equals(username) && "123".equals(password);
        String message = isValid ? "Đăng nhập thành công !" : "Đăng nhập thất bại !";
        model.addAttribute("message", message);
        model.addAttribute("username", username);
        return "login";
    }
}
