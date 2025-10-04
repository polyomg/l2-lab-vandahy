package com.poly.lab1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class L1_RectangleController {
    @Autowired
    HttpServletRequest req;

    @GetMapping("/rectangle/form")
    public String form() {
        return "rectangleCalculator";
    }

    @PostMapping("/rectangle/calculate")
    public String calculate(
            @RequestParam(name = "width", required = false) String widthParam,
            @RequestParam(name = "length", required = false) String lengthParam,
            Model model) {
        Float width = null;
        Float length = null;
        String error = null;

        try {
            if (widthParam != null && !widthParam.isBlank()) {
                width = Float.parseFloat(widthParam);
            }
            if (lengthParam != null && !lengthParam.isBlank()) {
                length = Float.parseFloat(lengthParam);
            }
            if (width == null || length == null) {
                error = "Vui lòng nhập đầy đủ chiều rộng và chiều dài";
            }
        } catch (NumberFormatException ex) {
            error = "Giá trị không hợp lệ. Vui lòng nhập số";
        }

        if (error == null) {
            float area = width * length;
            float perimeter = (width + length) * 2;
            model.addAttribute("area", area);
            model.addAttribute("perimeter", perimeter);
        }

        model.addAttribute("width", widthParam);
        model.addAttribute("length", lengthParam);
        model.addAttribute("error", error);
        return "rectangleCalculator";
    }
}
