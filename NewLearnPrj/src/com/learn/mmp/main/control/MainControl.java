package com.learn.mmp.main.control;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.learn.mmp.base.control.BaseControl;
import com.learn.mmp.main.model.MenuBean;
import com.learn.mmp.main.service.MenuService;
/**
 * 主页面控制器
 * @author liuwenkang
 *
 */
@Controller
@RequestMapping("/")
public class MainControl extends BaseControl {
    private final static String PAGE_ERR_404 = "/error/404";
    private final static String PAGE_NOTICE = "/notice/fjnuHqjtNotice";
    private final static String PAGE_WELCOME = "/welcome";
    private final static String MAIN_WELCOME = "/main";

    @Autowired
    private MenuService menuService;
    private List<MenuBean> menuList;
    private static Logger logger = LogManager.getLogger(MainControl.class);
    
    /**
     * 找不到页面时，跳转至404页面
     * @return
     */
    @RequestMapping("**")
    public String error404() {
        return PAGE_ERR_404;
    }

    /**
     * 显示公告页面
     * @return
     */
    @RequestMapping("/notice")
    public String toNoticePage() {
        return PAGE_NOTICE;
    }

    /**
     * 显示欢迎页面
     * @return
     */
    @RequestMapping("/welcome")
    public String toWelcome() {
        menuService.showMenu(0);
        return PAGE_WELCOME;
    }

    /**
     * 显示主页面
     * @return 
     */
    @RequestMapping("/main")
    public ModelAndView toMain() {
        menuList = menuService.showMenu(0);
        ModelAndView mav = new ModelAndView();
        mav.setViewName(MAIN_WELCOME);  //主页面 试图地址
        mav.addObject("menuList", menuList);//主页面第一层菜单
        return mav;
    }

    /**
     * 返回子菜单目录信息
     * @param menuId 父节点id
     * @param model
     * @return json
     */
    @ResponseBody
    @RequestMapping(path="/getsubmenu",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getSubMenu(int menuId, Model model) {
        menuList = menuService.showMenu(menuId);
        JSONArray menuListJson = new JSONArray(menuList);//
        logger.info(menuListJson.toString());
        /*DeferredResult<String> deferredResult = new DeferredResult<String>();
        deferredResult.setResult(menuListJson.toString());*/
        return menuListJson.toString();
    }
    
    /*//返回视图代码
    @RequestMapping("/getsubmenu")
    public ModelAndView getSubMenu(int menuId, Model model) {
        menuList = menuService.showMenu(menuId);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("newMenu");
        mav.addObject("menuList", menuList);
        return mav;
    }*/
    
    // getter & setter
    public MenuService getMenuService() {
        return menuService;
    }

    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

}
