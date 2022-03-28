package com.waste.my.domain;

import lombok.Data;

/**
 * @Author wykun
 * @Date 2022/3/27 15:00
 */
@Data
public class GoodsModel {
    private long id;
    private String goodsName;
    private String goodsType;
    private String goodsMoney;
    private String image;
}
