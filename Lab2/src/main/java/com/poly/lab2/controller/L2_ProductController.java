package com.poly.lab2.controller;

import com.poly.lab2.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product")
public class L2_ProductController {
    @GetMapping("/form")
    public String form(Model model) {
//        model.addAttribute("product", new Product());//initialize(khởi tạo) a blank object to avoid null
        Product p1 = new Product("iPhone 17", 1300.2);
        model.addAttribute("p1", p1);

        // thêm p2 trống để Thymeleaf không bị null khi chưa submit
        model.addAttribute("p2", new Product());
        return "product/form";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("p2") Product product,
        Model model
    ){
        // vẫn giữ p1 để hiển thị giá trị mặc định
        model.addAttribute("p1", new Product("iPhone 17", 1300.2));

        // p2 là giá trị user nhập vào
        model.addAttribute("p2", product);
        return "product/form";
    }

    @ModelAttribute("items")
    public List<Product> getProducts(){
        return Arrays.asList(
                new Product("Prd A", 123.0),
                new Product("Prd B", 171.0)
        );
    }
}
