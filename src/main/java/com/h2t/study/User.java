package com.h2t.study;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/08/02 16:38
 */
@TableName(value = "user")
public class User extends Base {
    @TableField(value = "username",exist = true)
    private String username;

    @TableField(value = "password",exist = true)
    private String password;
}
