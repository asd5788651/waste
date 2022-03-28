package com.waste.my.mapper;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author wykun
 * @Date 2022/3/23 20:13
 */
@Data
public class VipDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("user_id")
    private String userId;
    @TableField("user_name")
    private String userName;
    @TableField("user_password")
    private String userPassword;
    @TableField("user_msg")
    private String userMsg;
    @TableField(fill = FieldFill.INSERT,value = "create_time")
    private Date createTime;
    @TableField("create_man")
    private String createMan;
    @TableField(fill = FieldFill.INSERT_UPDATE,value = "update_time")
    private Date updateTime;
    @TableField("update_man")
    private String updateMan;
    @TableField("delete_flag")
    private Integer deleteFlag;
    @TableField("address")
    private String address;
}
