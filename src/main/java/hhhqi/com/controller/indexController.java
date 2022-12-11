package hhhqi.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 首页界面跳转
@Controller
public class indexController {
    @GetMapping("/")
    public String hello() {
        return "redirect:/pages/login.html";
    }
}
