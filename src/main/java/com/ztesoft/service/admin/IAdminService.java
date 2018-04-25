package com.ztesoft.service.admin;


import com.ztesoft.pojo.admin.Admin;

import java.util.List;

/**
 * Created by Dong on 2018/4/24.
 */
public interface IAdminService {
    /**
     * 查询数据
     * @return List
     */
    public List<Admin> getAdminList();//查询用户列表
    public Admin getAdminByAccount(String account);//通过用户账号查询用户信息

    /**
     * 添加数据
     */
    public int addAdmin(Admin admin);//添加新用户信息

    /**
     * 删除数据
     */
    public int deleteAdminByAccount(String account);//根据用户账户注销该用户


    /**
     * 修改数据
     */
    public int updateAdminInfo(Admin admin);//修改用户信息
}
