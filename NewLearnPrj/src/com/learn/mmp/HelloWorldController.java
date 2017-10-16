package com.learn.mmp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    @RequestMapping("/helloworld")
    public String helloWorld(Model model) {
            model.addAttribute("message", "Hello World!");
//            System.out.println("hello/hello");
            return "hello/hello";
    }

}
