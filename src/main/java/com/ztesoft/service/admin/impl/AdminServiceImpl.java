package com.ztesoft.service.admin.impl;

import com.ztesoft.dao.admin.AdminMapper;
import com.ztesoft.pojo.admin.Admin;
import com.ztesoft.service.admin.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Dong on 2018/4/24.
 */
@Service("IAdminService")
public class AdminServiceImpl implements IAdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    //查询所有用户信息列表
    public List<Admin> getAdminList() {
        return adminMapper.getAdminList();
    }

    @Override
    //通过用户账号查询用户
    public Admin getAdminByAccount(String account) {
        return adminMapper.getAdminByAccount(account);
    }

    @Override
    //添加新用户
    public int addAdmin(Admin admin) {
        admin.setUuid(UUID.randomUUID().toString());
        int result = adminMapper.userRegister(admin);
        if(result > 0){
            return 1;
        }
        return 0;
    }

    @Override
    //通过用户账号注销用户
    public int deleteAdminByAccount(String account) {
        int result = adminMapper.deleteAdminByAccount(account);
        if(result > 0){
            return 1;
        }
        return 0;
    }

    @Override
    //更新用户信息
    public int updateAdminInfo(Admin admin) {
        if(0 < adminMapper.updateAdminByAccount(admin)){
            return 1;
        }
        return 0;
    }
}
