package com.poly.lab6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.dao.CategoryDAO;
import poly.edu.entity.lab6.Category;

import java.util.List;

@Controller
public class L6_CategoryController {
    @Autowired
    CategoryDAO dao;

    @RequestMapping("/category/index")
    String index(Model model){
        Category item = new Category();
        model.addAttribute("item",item);
        List<Category> items = dao.findAll();
        model.addAttribute("items",items);
        return "lab6/category/index";
        //item fill to form
        //items fill to table
    }
}
