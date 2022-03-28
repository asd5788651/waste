package com.waste.my.mapper;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author wykun
 * @Date 2022/3/27 18:39
 */
@Data
@TableName("ra_order")
public class OrderDO {
    private long id;
    @TableField("order_code")
    private String orderCode;
    @TableField("delete_flag")
    private Integer deleteFlag;
    @TableField(fill = FieldFill.INSERT,value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @TableField("recycle_man")
    private String recycleMan;
    @TableField("user")
    private String user;
    @TableField("status")
    private String status;
    @TableField("pay_mode")
    private String payMode;
    private String phone;
    private String money;
}
