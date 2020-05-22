package com.atguigu.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: hftang
 * @Date: 2020/4/21 18:50
 * @Description:
 */
@Data
public class User {


    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    @Version
    private Integer version;


    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
