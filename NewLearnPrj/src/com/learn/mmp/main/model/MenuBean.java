package com.learn.mmp.main.model;

import com.learn.mmp.base.model.BaseBean;

public class MenuBean extends BaseBean{
    private String menuId;
    private String menuName;
    private String parentId;
    private String path;
    private String createTime;
    private String status;
    private String orderId;
/*
    private static final class MenuBeanMapper implements RowMapper<MenuBean> {
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
    }
*/
    @Override
    public String toString() {
        return "MenuBean [menuId=" + menuId + ", menuName=" + menuName + ", parentId=" + parentId + ", path=" + path
                + ", createTime=" + createTime + ", status=" + status + ", orderId=" + orderId + "]";
    }

    // getter & setter
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
