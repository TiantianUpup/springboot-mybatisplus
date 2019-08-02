package com.h2t.study;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/08/02 16:39
 */
public class Base {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "gmtCreate",exist = true)
    private Date gmtCreate;

    @TableField(value = "gmtModify",exist = true)
    private Date gmtModify;
}
