package com.learn.mmp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.mmp.base.serivice.BaseService;
import com.learn.mmp.main.dao.MenuDao;
import com.learn.mmp.main.model.MenuBean;

/**
 * �˵�serivice�����ڲ˵�����
 * @author liuwenkang
 *
 */
@Service
public class MenuService extends BaseService {
    @Autowired
    private MenuDao menuDao;

    /**
     * ��ȡ�˵�
     * @param parentId ���ڵ� 
     * @return ���� ��Ӧ���ӽڵ�ļ��ϣ�������ڵ�<0���򷵻�null
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
