package com.learn.mmp.main.dao;

import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.mmp.main.model.MenuBean;

@Repository
public class HelloDao {

    private JdbcTemplate jdbcTemplate;

    /*private static final class MenuBeanMapper implements RowMapper<MenuBean> {
        @Override
        public MenuBean mapRow(ResultSet rs, int rowNum) throws SQLException {
            MenuBean menuBean = new MenuBean();
            menuBean.setMenuId(rs.getString("menu_id"));
            menuBean.setMenuName(rs.getString("menu_name"));
            menuBean.setParentId(rs.getString("parent_id"));
            menuBean.setPath(rs.getString("path"));
            menuBean.setCreateTime(rs.getString("create_time"));
            menuBean.setStatus(rs.getString("status"));
            menuBean.setOrderId(rs.getString("order_id"));
            return menuBean;
        }
    }*/
    public void print() {// select * from tb_menu
        System.out.println("------jdbcTemplate" + this.jdbcTemplate);
/*        List<Map<String, Object>> lastName = this.jdbcTemplate.queryForList("select * from tb_menu");

        for (Map<String, Object> map : lastName) {
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> entry = it.next();
                System.out.println("key= " + entry.getKey() + " , value= " + entry.getValue());
            }
            System.out.println("=====");
        }
*/
        List<MenuBean> menuList = new ArrayList<MenuBean>();
        //menuList = this.jdbcTemplate.query("select * from tb_menu", new MenuBeanMapper());
        menuList = this.jdbcTemplate.query("select * from tb_menu", new BeanPropertyRowMapper<MenuBean>(MenuBean.class));
        for (MenuBean menuBean : menuList) {
            System.out.println(menuBean);
        }
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

}
