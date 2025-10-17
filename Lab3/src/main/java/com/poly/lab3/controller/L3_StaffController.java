package com.poly.lab3.controller;

import com.poly.lab3.entity.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class L3_StaffController {
    @RequestMapping("/staff")
    public String formStaff(Model model) {
        Staff staff = Staff.builder()
                .id("S01")
                .name("văn đahy")
                .photo("staff.png")
                .gender(true)
                .birthday(new Date(107, 6, 7))
                .salary(120.5)
                .level(2)
                .build();
        model.addAttribute("staff", staff);
        return "/staff-lab3/staff";
    }
}
