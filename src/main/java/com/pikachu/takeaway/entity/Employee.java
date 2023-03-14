package com.pikachu.takeaway.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String name;

    private String password;

    private String phone;

    private String sex;

    private String idNumber;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)//公共字段，在insert时自动填充字段
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)//在insert和update时填充字段
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)//insert时填入字段
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)//insert和update时填充字段
    private Long updateUser;

}
