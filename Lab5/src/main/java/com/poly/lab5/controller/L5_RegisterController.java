package com.poly.lab5.controller;

import com.poly.lab5.service.L5_CookieService;
import com.poly.lab5.service.L5_ParamService;
import com.poly.lab5.service.L5_SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class L5_RegisterController {
    @Autowired
    L5_ParamService paramService;
    @Autowired
    L5_SessionService sessionService;
    @Autowired
    L5_CookieService cookieService;
    @GetMapping("/account/register")
    public String register(){
        return "lab5/account/register";
    }

    @PostMapping("/account/register")
    public String save(@RequestParam("photo") MultipartFile file){
        String un =  paramService.getString("username", "");
        String pw =  paramService.getString("password", "");

        sessionService.set("username",un);
        sessionService.set("password",pw);
        File savedFile = paramService.save(file, "/uploads");
        return "redirect:/account/login";
    }
}
