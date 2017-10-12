package com.learn.mmp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class s {
    @GetMapping("/hello")
    public String handle(Model model) {
            model.addAttribute("message", "Hello World!");
            return "index";
    }

}
