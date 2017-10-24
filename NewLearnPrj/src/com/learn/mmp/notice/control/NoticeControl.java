package com.learn.mmp.notice.control;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import com.learn.mmp.notice.model.NoticeConfBean;

@Controller
@RequestMapping("/notice")
public class NoticeControl {
    private final static String PAGE_ERR_404 = "/jsps/error/404.jsp";
    private final static String PAGE_WELCOME = "/welcome";
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomBooleanEditor booleanEditor = new CustomBooleanEditor("true", "false", true);
        binder.registerCustomEditor(boolean.class, booleanEditor);
    }

    @RequestMapping("/**")
    public String error404() {
        return PAGE_ERR_404;
    }

    @RequestMapping("/submitConf")
    public String submitConf(NoticeConfBean conf/*, String isSendImm*/) {
        /*if ("true".equals(isSendImm)) {
            conf.setIsSendImm(true);
        } else {
            conf.setIsSendImm(false);
        }*/
        System.out.println("----------------" + conf);
        return PAGE_WELCOME;
    }

}
