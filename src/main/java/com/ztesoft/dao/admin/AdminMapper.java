package com.ztesoft.dao.admin;

import com.ztesoft.pojo.admin.Admin;

import java.util.List;

/**
 * Created by Dong on 2018/4/24.
 */
public interface AdminMapper {
    /**
     * 添加数据
     * @return
     */
    public int userRegister(Admin admin);

    /**
     * 删除数据
     */
    public int deleteAdminByAccount(String account);

    /**
     * 修改数据
     */
    public int updateAdminByAccount(Admin admin);

    /**
     * 查询数据
     */
    public List<Admin> getAdminList();//查询所有数据
    public Admin getAdminByAccount(String account);//根据账户查询用户信息

}