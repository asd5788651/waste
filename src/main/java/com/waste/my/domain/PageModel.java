package com.waste.my.domain;

import lombok.Data;

/**
 * @Author wykun
 * @Date 2022/3/23 20:15
 */
@Data
public class PageModel {
    private Integer start;
    private Integer pageSize;
    private String username;
}
