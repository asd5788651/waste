package com.waste.my.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author wykun
 * @Date 2022/3/23 20:18
 */
@Data
public class UserVO {
    private Long id;
    private String userName;
    private String userPassword;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
}
