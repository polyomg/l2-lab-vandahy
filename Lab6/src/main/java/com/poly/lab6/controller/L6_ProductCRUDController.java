package com.poly.lab6.controller;

import com.poly.lab6.dao.CategoryDAO;
import com.poly.lab6.dao.ProductDAO;
import com.poly.lab6.entity.lab6.Category;
import com.poly.lab6.entity.lab6.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class L6_ProductCRUDController {
    @Autowired
    private ProductDAO pdao;

    @Autowired
    private CategoryDAO cdao;

    @GetMapping("/index")
    public String index(Model model) {
        Product item = new Product();
        model.addAttribute("item", item);
        List<Product> items = pdao.findAll();
        model.addAttribute("items", items);
        List<Category> categories = cdao.findAll();
        model.addAttribute("categories", categories);
        return "lab6/product/productCRUD";
    }

    @PostMapping("/create")
    public String create(Product item) {
        pdao.save(item);
        return "redirect:/product/index";
    }

    @PostMapping("/update")
    public String update(Product item) {
        pdao.save(item);
        return "redirect:/product/edit/" + item.getId();
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Product item = pdao.findById(id).get();
        model.addAttribute("item", item);
        List<Product> items = pdao.findAll();
        model.addAttribute("items", items);
        List<Category> categories = cdao.findAll();
        model.addAttribute("categories", categories);
        return "lab6/product/productCRUD";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        pdao.deleteById(id);
        return "redirect:/product/index";
    }
}
