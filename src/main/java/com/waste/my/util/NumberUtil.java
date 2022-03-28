package com.waste.my.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author wykun
 * @Date 2022/3/27 19:03
 */
public class NumberUtil {

    private final static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");

    /**
     * 生成18位随机时间戳
     *
     * @return
     */
    public static String dateRandom16() {

        //获取当前年月日
        String date = yyyyMMdd.format(new Date());

        //获取时间戳后6位
        String timeMillis = String.valueOf(System.currentTimeMillis());
        String fiveNumber = timeMillis.substring(timeMillis.length() - 6);

        //获取随机数后4位
        String tempRandom = String.valueOf(Math.random());
        String number = tempRandom.substring(tempRandom.length() - 4);

        //生成18位随机时间戳数字
        return date + fiveNumber + number;
    }
}

