package com.ztesoft.pojo.admin;

import java.util.Date;

/**
 * Created by Dong on 2018/4/24.
 */
public class Admin {
    private String uuid;//uuid
    private String account;//账户
    private String password;//密码
    private Date createTime;//注册时间

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}