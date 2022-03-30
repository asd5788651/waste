package com.waste.my.mapper;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author wykun
 * @Date 2022/3/23 20:13
 */
@Data
@TableName("w_user")
public class CycleManDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("user_code")
    private String userCode;
    @TableField("username")
    private String userName;
    @TableField("password")
    private String userPassword;
    @TableField("phone")
    private String phone;
    @TableField(fill = FieldFill.INSERT,value = "create_time")
    private Date createTime;
    @TableField("email")
    private String email;
//    @TableField(fill = FieldFill.INSERT_UPDATE,value = "update_time")
//    private Date updateTime;
    @TableField("sex")
    private String sex;
    @TableField("delete_flag")
    private Integer deleteFlag;
    @TableField("address")
    private String address;
}
