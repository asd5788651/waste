package com.waste.my.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author 10447
 * @Date 2022/3/11 22:12
 * @Version 1.0
 */
@Data
public class UserModel {
    private Long id;
    private String userName;
    private String userPassword;
    private Date createTime;
}
