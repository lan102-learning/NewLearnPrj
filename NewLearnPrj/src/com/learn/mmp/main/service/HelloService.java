package com.learn.mmp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.mmp.base.serivice.BaseService;
import com.learn.mmp.main.dao.HelloDao;

@Service
public class HelloService extends BaseService{
    @Autowired
    private HelloDao helloDao ;
    
    public void print() {
        System.out.println("------dao:"+helloDao);
        helloDao.print();
    }

    public HelloDao getHelloDao() {
        return helloDao;
    }

    public void setHelloDao(HelloDao helloDao) {
        this.helloDao = helloDao;
    }
    
    
}
