package com.waste.my.controller;

import com.waste.my.domain.PageModel;
import com.waste.my.domain.UserModel;
import com.waste.my.service.UserService;
import com.waste.my.util.Result;
import com.waste.my.util.ResultUtil;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 10447
 * @Date 2022/3/11 22:17
 * @Version 1.0
 */

@RestController
@CrossOrigin
@RequestMapping("/api/waster/")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user/create")
    public Result createUser(@RequestBody UserModel userModel) {
        if (userService.createUser(userModel) > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failed("创建失败！");
        }
    }

    @PostMapping("/user/login")
    public Result LoginUser(@RequestBody UserModel userModel) {
        return userService.loginUser(userModel);
    }

    @PostMapping("/user/root-list")
    public Result rootList(@RequestBody PageModel pageModel) {
        return userService.queryUserList(pageModel);
    }

    @GetMapping("/user/root-delete/{id}")
    public Result rootList(@PathVariable String id) {
        Integer integer = userService.deleteUser(id);
        return ResultUtil.success(integer);
    }

    @GetMapping("/user/root-one/{id}")
    public Result rootOne(@PathVariable Integer id) {
        return userService.queryUserOne(id);
    }

    @PostMapping("/user/root-update")
    public Result rootOne(@RequestBody UserModel userModel) {
        Integer integer = userService.udpateUser(userModel);
        if(integer>0){
            return ResultUtil.success(integer);
        }
        return ResultUtil.failed("更新失败");
    }


}
