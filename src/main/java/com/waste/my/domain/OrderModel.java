package com.waste.my.domain;

import lombok.Data;

/**
 * @Author wykun
 * @Date 2022/3/27 18:57
 */
@Data
public class OrderModel {
    private long id;
    private String user;
    private String recycleMan;
    private String phone;
    private String address;
    private String payMode;
    private String status;
    private String money;

}
