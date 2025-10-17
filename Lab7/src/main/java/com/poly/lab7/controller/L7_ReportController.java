package com.poly.lab7.controller;

import com.poly.lab7.dao.ProductDAO;
import com.poly.lab7.entity.lab7.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class L7_ReportController {
    @Autowired
    ProductDAO dao;
    @RequestMapping("/report/inventory-by-category")
    public String inventory(Model model){
        List<Report> items = dao.getInventoryByCategory();
        model.addAttribute("items",items);
        return "lab7/report/inventory-by-category";
    }
}
