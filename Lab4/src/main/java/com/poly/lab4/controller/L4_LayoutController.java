package com.poly.lab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class L4_LayoutController {
    @RequestMapping("/index")
    public String index(){
        return "/lab4/page/home";
    }

    @RequestMapping("/about")
    public String about(){
        return "/lab4/page/about";
    }
}
