package com.learn.mmp.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainControl {
    private final static String PAGE_ERR_404="/jsps/error/404.jsp";
    private final static String PAGE_NOTICE="/jsps/notice/fjnuHqjtNotice.jsp";
    private final static String PAGE_WELCOME="/jsps/welcome.jsp";
    @RequestMapping("**")
    public String error404() {
        return PAGE_ERR_404;
    }
    @RequestMapping("/notice")
    public String toNoticePage() {
        return PAGE_NOTICE;
    }
    
    @RequestMapping("/welcome")
    public String toWelcome() {
        return PAGE_WELCOME;
    }
}
