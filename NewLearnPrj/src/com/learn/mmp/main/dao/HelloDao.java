package com.learn.mmp.main.dao;

import java.util.Iterator;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {

    
    private JdbcTemplate jdbcTemplate;

    public void print() {// select * from tb_menu
        System.out.println("--------jdbcTemplate" + this.jdbcTemplate);
        List<Map<String, Object>> lastName = this.jdbcTemplate.queryForList("select * from tb_menu");
        for (Map<String, Object> map : lastName) {
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> entry = it.next();
                System.out.println("key= " + entry.getKey() + " , value= " + entry.getValue());
            }
        }

    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

}
