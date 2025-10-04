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

    @RequestMapping("staff/list")
    public String list(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("user1@gmail.com").name("nguyễn văn user1").level(0).build(),
                Staff.builder().id("user2@gmail.com").name("nguyễn văn user2").level(1).build(),
                Staff.builder().id("user3@gmail.com").name("nguyễn văn user3").level(2).build(),
                Staff.builder().id("user4@gmail.com").name("nguyễn văn user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").name("nguyễn văn user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").name("nguyễn văn user6").level(0).build()
        );
        model.addAttribute("list", list);
        return "/staff-lab3/staff-list";
    }

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

    @RequestMapping("staff/list-controls")
    public String list_controls(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("user1@gmail.com").name("nguyễn văn user1").level(0).build(),
                Staff.builder().id("user2@gmail.com").name("nguyễn văn user2").level(1).build(),
                Staff.builder().id("user3@gmail.com").name("nguyễn văn user3").level(2).build(),
                Staff.builder().id("user4@gmail.com").name("nguyễn văn user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").name("nguyễn văn user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").name("nguyễn văn user6").level(0).build()
        );
        model.addAttribute("listCT", list);
        return "/staff-lab3/list-controls";
    }
}
