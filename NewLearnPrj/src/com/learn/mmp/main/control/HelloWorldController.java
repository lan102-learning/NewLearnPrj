package com.learn.mmp.main.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learn.mmp.main.service.HelloService;

@Controller
@RequestMapping("/hello/")
public class HelloWorldController {

    @Autowired
    HelloService helloService = new HelloService();

    @RequestMapping("**")
    public String error404() {
        return "/error/404";
    }

    @RequestMapping("/helloworld")
    public String helloWorld(Model model) {
        System.out.println("------Service:"+helloService);
        model.addAttribute("message", "Hello World!");
        // System.out.println("hello/hello");
        helloService.print();
        return "/hello/hello";
    }

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

}
