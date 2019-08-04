package com.h2t.study.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/08/02 16:38
 */
@TableName(value = "users")
public class Users extends Base {
    @TableField(value = "user_name", exist = true)
    private String username;

    @TableField(value = "password", exist = true)
    private String password;

    public Users() {
        super();
    }

    //getter and setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
