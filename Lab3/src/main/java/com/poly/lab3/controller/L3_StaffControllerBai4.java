package com.poly.lab3.controller;

import com.poly.lab3.entity.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class L3_StaffControllerBai4 {
    @RequestMapping("staff/list-status")
    public String list_status(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("user1@gmail.com").name("nguyễn văn user1").level(0).build(),
                Staff.builder().id("user2@gmail.com").name("nguyễn văn user2").level(1).build(),
                Staff.builder().id("user3@gmail.com").name("nguyễn văn user3").level(2).build(),
                Staff.builder().id("user4@gmail.com").name("nguyễn văn user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").name("nguyễn văn user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").name("nguyễn văn user6").level(0).build()
        );
        model.addAttribute("listST", list);
        return "/staff-lab3/list-status";
    }
}
