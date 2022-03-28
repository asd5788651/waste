package com.waste.my.util;

import lombok.Data;

/**
 * @Author 10447
 * @Date 2022/3/11 22:06
 * @Version 1.0
 */
@Data
public class Result {
    private Integer code;
    private String message;
    private Object data;
}
