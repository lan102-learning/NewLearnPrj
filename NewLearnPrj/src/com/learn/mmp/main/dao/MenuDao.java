package com.learn.mmp.main.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.mmp.base.dao.BaseDao;
import com.learn.mmp.main.model.MenuBean;

/**
 * �˵�Dao���˵��й����ݿ����
 * @author liuwenkang
 *
 */
@Repository
public class MenuDao extends BaseDao {
    private static Logger logger = LogManager.getLogger(MenuDao.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    /**
     * ��ȡ�˵�
     * @param parentId ���ڵ� 
     * @return ���� ��Ӧ���ӽڵ�ļ��ϣ�������ڵ�<0���򷵻�null
     */
    public List<MenuBean> getMenuList(int parentId){
        //
       StringBuffer sb = new StringBuffer("");
       sb.append(" select menu_id,menu_name,parent_id,path,if(order_id is null,999,order_id) order_id ");
       sb.append("from tb_menu where status=1 ");
       if(parentId>=0) {
           sb.append(" and parent_id = "+parentId);
           sb.append(" order by order_id");
       } else {
          return null;
       }
       
       logger.info(sb.toString());
       return this.jdbcTemplate.query(sb.toString(),new BeanPropertyRowMapper<MenuBean>(MenuBean.class));
    }

}
