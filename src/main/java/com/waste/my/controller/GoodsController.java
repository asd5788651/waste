package com.waste.my.controller;

import com.waste.my.domain.GoodsModel;
import com.waste.my.service.GoodService;
import com.waste.my.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author wykun
 * @Date 2022/3/27 15:05
 */
@RestController
@CrossOrigin
@RequestMapping("/api/waster/good")
public class GoodsController {

    @Autowired
    private GoodService goodService;

    @GetMapping("query-list")
    public Result queryList(){
        return  goodService.queryGoodsList();
    }

    @PostMapping("create")
    public Result create(@RequestBody GoodsModel goodsModel){
        return  goodService.createGoods(goodsModel);
    }
    @GetMapping("delete/{id}")
    public Result delete(@PathVariable Long id){
        return  goodService.deleteGoods(id);
    }

    @GetMapping("query-one/{id}")
    public Result queryOne(@PathVariable long id){
        return goodService.queryOne(id);
    }

    @PostMapping("update")
    public Result update(@RequestBody GoodsModel goodsModel){
        return goodService.updateGood(goodsModel);
    }
}
