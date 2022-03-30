package com.waste.my.controller;

/**
 * @Author wykun
 * @Date 2022/3/29 10:55
 */

import com.waste.my.domain.CycleManModel;
import com.waste.my.service.CycleManService;
import com.waste.my.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/waster/cycle")
public class CycleContoller {

    @Autowired
    private CycleManService cycleManService;

    @PostMapping("create")
    public Result create(@RequestBody CycleManModel cycleManModel){
        return  cycleManService.create(cycleManModel);
    }

    @GetMapping("delete/{id}")
    public Result delete(@PathVariable long id){
        return  cycleManService.delete(id);
    }
    @GetMapping("query-list")
    public Result delete(){
        return  cycleManService.queryList();
    }
    @PostMapping("update")
    public Result update(@RequestBody CycleManModel cycleManModel){
        return  cycleManService.update(cycleManModel);
    }
    @GetMapping("query-one/{id}")
    public Result queryOne(@PathVariable long id){
        return  cycleManService.queryOne(id);
    }


}
