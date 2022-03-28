package com.waste.my.controller;

import com.waste.my.domain.OrderModel;
import com.waste.my.service.OrderService;
import com.waste.my.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author wykun
 * @Date 2022/3/27 18:47
 */
@RestController
@CrossOrigin
@RequestMapping("/api/waster/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("query-list")
    public Result queryList(){
     return    orderService.queryList();
    }

    @PostMapping("create")
    public Result Create(@RequestBody OrderModel orderModel){
        return    orderService.create(orderModel);
    }

    @GetMapping("delete/{id}")
    public Result delete(@PathVariable Long id){
        return    orderService.delete(id);
    }
}
