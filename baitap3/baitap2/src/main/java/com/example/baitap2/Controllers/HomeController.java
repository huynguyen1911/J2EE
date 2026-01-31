package com.example.baitap2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

// @RestController
// public class HomeController {

//     @GetMapping("/home")
//     public String home() {
//         return "Hello World";
//     }
// }

@Controller

public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Xin Chao Thymeleaf");
        return "index";
    }
}
