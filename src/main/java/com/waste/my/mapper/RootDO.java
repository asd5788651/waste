package com.waste.my.mapper;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by yukun wang on 2022/3/11 21:55
 */
@Data
@TableName("ra_root")
public class RootDO {
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

}
