package com.learn.mmp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.mmp.base.serivice.BaseService;
import com.learn.mmp.main.dao.MenuDao;
import com.learn.mmp.main.model.MenuBean;

/**
 * 菜单serivice，用于菜单服务
 * @author liuwenkang
 *
 */
@Service
public class MenuService extends BaseService {
    @Autowired
    private MenuDao menuDao;

    /**
     * 获取菜单
     * @param parentId 父节点 
     * @return 返回 对应的子节点的集合，如果父节点<0，则返回null
     */
    public List<MenuBean> showMenu(int parentId) {
       return menuDao.getMenuList(parentId);
    }
    
    
    //getter & setter 
    public MenuDao getMenuDao() {
        return menuDao;
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
    
}
