package com.waste.my.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author wykun
 * @Date 2022/3/23 20:13
 */
@Data
public class VipModel {
    private Integer id;
    private String userName;
    private String userPassword;
    private Date createTime;
    private String address;
}
