package com.waste.my.mapper;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author wykun
 * @Date 2022/3/27 14:16
 */
@TableName("w_type")
@Data
public class GoodTypeDo {
    private long    id;
    @TableField("type_name")
    private String typeName;
    @TableField("delete_flag")
    private Integer deleteflag;
}
