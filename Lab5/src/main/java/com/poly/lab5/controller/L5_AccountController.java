package com.poly.lab5.controller;

import com.poly.lab5.service.L5_CookieService;
import com.poly.lab5.service.L5_ParamService;
import com.poly.lab5.service.L5_SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class L5_AccountController {
    @Autowired
    L5_ParamService paramService;
    @Autowired
    L5_CookieService cookieService;
    @Autowired
    L5_SessionService sessionService;

    @GetMapping("/account/login")
    public String login1() {
        return "lab5/account/login";
    }

    @PostMapping("/account/login")
    public String login2() {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);

        String regUser = sessionService.get("username");
        String regPass = sessionService.get("password");

//        if (un.equals("poly") || pw.equals("123")) {
//            sessionService.set("username", un);
//
//            if (rm){
//                cookieService.add("user", un, 10 * 24);
//            }else {
//                cookieService.remove("user");
//            }
//            return "redirect:/item/index";
//        } của bài 2, bài 3 sẽ cải tiến lấy dữ liệu đã đăng kí rồi đăng nhập

        if (un.equals(regUser) && pw.equals(regPass)) {
            sessionService.set("username", un);
            if (rm) {
                cookieService.add("user", un, 10 * 24); // 10 ngày
            } else {
                cookieService.remove("user");
            }
            return "redirect:/cart/view";
        }
        return "lab5/account/login";
    }
}
