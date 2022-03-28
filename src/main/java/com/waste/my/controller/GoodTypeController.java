package com.waste.my.controller;

import com.waste.my.service.GoodTypeService;
import com.waste.my.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wykun
 * @Date 2022/3/27 14:21
 */
@RestController
@CrossOrigin
@RequestMapping("/api/waster/")
public class GoodTypeController {

    @Autowired
    private GoodTypeService goodTypeService;

    @GetMapping("goods-type")
    public Result queryGoodTypeList(){
     return    goodTypeService.queryGoodTypeList();
    }
}
