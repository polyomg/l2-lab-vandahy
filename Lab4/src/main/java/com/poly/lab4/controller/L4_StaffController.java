package com.poly.lab4.controller;

import com.poly.lab4.entity.Staff;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class L4_StaffController {
    @GetMapping("/staff/create/form")
    public String createForm(Model model, @ModelAttribute("staff") Staff staff) {
        model.addAttribute("message", "Vui lòng nhập nhân viên !");
        return "lab4/staff-create";
    }

    @PostMapping("/staff/create/save")
    public String save(Model model,
                       @Valid @ModelAttribute("staff") Staff staff, Errors errors,
                       @RequestPart("photo_file") MultipartFile photoFile
    ) {
        if (!photoFile.isEmpty()){
            staff.setPhoto(photoFile.getName());
        }
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau");
        }else{
            model.addAttribute("message", "Xin chào " + staff.getName() + ", Dữ liệu bạn đã nhập đúng");
        }
        return "lab4/staff-create";
    }
}
