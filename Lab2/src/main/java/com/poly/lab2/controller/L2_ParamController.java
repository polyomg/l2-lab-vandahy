package com.poly.lab2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class L2_ParamController {
    @RequestMapping("/param/form")
    public String form() {
        return "formParam";
    }

    @RequestMapping("/param/save/{x}")
    public String save(
            @PathVariable("x") String x,
            @RequestParam("y") String y,
            Model model) {
        model.addAttribute("x", "Value of X: " + x);
        model.addAttribute("y", "Value of Y: " + y);
        return "formParam";
    }
}
