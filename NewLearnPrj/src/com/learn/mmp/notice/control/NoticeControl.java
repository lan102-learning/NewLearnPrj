package com.learn.mmp.notice.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learn.mmp.notice.model.NoticeConfBean;

@Controller
@RequestMapping("/notice")
public class NoticeControl {
    private final static String PAGE_ERR_404="/jsps/error/404.jsp";
    
    @RequestMapping("/**")
    public String error404() {
        return PAGE_ERR_404;
    }
    
    @RequestMapping("/submitConf")
    public String submitConf(NoticeConfBean conf, String isSendImm){
        if("true".equals(isSendImm)) {
            conf.setSendImm(true);
        }else {
            conf.setSendImm(false);
        }
        System.out.println("----------------"+conf);
        return "jsps/welcome.jsp";
    }
}
