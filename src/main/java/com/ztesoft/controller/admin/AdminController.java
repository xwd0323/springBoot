package com.ztesoft.controller.admin;

import com.ztesoft.pojo.admin.Admin;
import com.ztesoft.service.admin.IAdminService;
import com.ztesoft.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dong on 2018/4/24.
 */
@Controller
public class AdminController {
    @Autowired
    IAdminService iAdminService;

    @Autowired
    private RedisOperator redis;

    /**
     * 测试
     * @return
     */
    /*简单的输出*/
    @GetMapping(value = "hello")
    @ResponseBody
    public String sayHello(){
        return "hello";
    }



    /**
     * 查询数据
     * @return
     */

    /*获取所有信息*/
    @GetMapping(value = "getAdminList")
    @ResponseBody
    public List<Admin> getAdminLists(){
        redis.set("account","xwd");
        return iAdminService.getAdminList();
    }

    //根据账户查询用户信息
    @PostMapping("getAdmin")
    @ResponseBody
    public Admin getAdmin(String account){
        Admin admin =  iAdminService.getAdminByAccount(account);
        redis.set("adminInfo",admin.toString());
        return admin;
    }


    /**
     * 添加数据
     * @param admin
     * @return
     */

    //新用户注册
    @PostMapping(value = "registerUser")
    @ResponseBody
    public int userRegister(@RequestBody Admin admin){
        return iAdminService.addAdmin(admin);
    }

    /**
     * 修改数据
     */
    //更新用户信息
    @PostMapping("updateAdmin")
    @ResponseBody
    public int updateAdmin(@RequestBody Admin admin){
        return iAdminService.updateAdminInfo(admin);
    }

    /**
     * 删除数据
     */
    //根据用户账号注销用户
    @PostMapping("deleteAdmin")
    @ResponseBody
    public int deleteAdminByAccount(String account){
        return iAdminService.deleteAdminByAccount(account);
    }

    /**
     * 跳转
     */
    @RequestMapping("/")
    public String toPage(){
        return "index";
    }
}

