package com.waste.my.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.waste.my.domain.PageModel;
import com.waste.my.mapper.CycleManMapper;
import com.waste.my.mapper.RootDO;
import com.waste.my.mapper.RootMapper;
import com.waste.my.domain.UserModel;
import com.waste.my.util.GenerateUserId;
import com.waste.my.util.Result;
import com.waste.my.util.ResultUtil;
import com.waste.my.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author 10447
 * @Date 2022/3/11 22:06
 * @Version 1.0
 */
@Service
public class UserService {


    @Autowired
    private RootMapper userMapper;

    @Autowired
    private CycleManMapper cycleManMapper;

    /**
     * @Description: 创建用户
     * @Author: yukun Wang
     * @Date: 2022/3/11
     */
    public Integer createUser(UserModel userModel) {
        RootDO userDO = new RootDO();
        BeanUtils.copyProperties(userModel, userDO);
        userDO.setUserId(GenerateUserId.generate());
//        userDO.setUserPassword(MD5Tools.string2MD5(userDO.getUserPassword()));
        return userMapper.insert(userDO);
    }


    public Integer udpateUser(UserModel userModel) {
        RootDO userDO = new RootDO();
        BeanUtils.copyProperties(userModel, userDO);
        int insert = userMapper.updateById(userDO);
        return insert;
    }

    public Integer deleteUser(String userId) {
        RootDO userDO = new RootDO();
        QueryWrapper<RootDO> wrapper = new QueryWrapper<>();
        wrapper.eq("id", userId);
        userDO.setDeleteFlag(1);
        int insert = userMapper.update(userDO, wrapper);
        return insert;
    }

    public Result loginUser(UserModel model) {
        QueryWrapper<RootDO> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", model.getUserName());
        wrapper.eq("user_password", model.getUserPassword());
        wrapper.eq("delete_flag",0);
        List<RootDO> userDOS = userMapper.selectList(wrapper);
        QueryWrapper wrapper1=new QueryWrapper();
        wrapper1.eq("username",model.getUserName());
        wrapper1.eq("password",model.getUserPassword());
        wrapper1.eq("delete_flag",0);
        List list = cycleManMapper.selectList(wrapper1);
        if (userDOS.size() < 1&&list.size()<0) {
            return ResultUtil.failed("用户名或密码错误!");
        } else {
            return ResultUtil.success();
        }
    }

    public Result queryUserList(PageModel pageModel) {
        List<UserVO> userVOList = new ArrayList<>();
        QueryWrapper<RootDO> wrapper = new QueryWrapper<>();
        wrapper.eq("delete_flag",0);
        if (!StrUtil.isBlankIfStr(pageModel.getUsername())) {
            wrapper.eq("user_name", pageModel.getUsername());
        }
        Page<RootDO> userDOPage = new Page<>(pageModel.getStart(), pageModel.getPageSize());
        IPage<RootDO> userDOIPage = userMapper.selectPage(userDOPage, wrapper);
        for (RootDO u : userDOIPage.getRecords()) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(u, userVO);
            userVOList.add(userVO);
        }
        return ResultUtil.success(userVOList);
    }

    public Result queryUserOne(Integer id) {
        UserVO userVO = new UserVO();
        QueryWrapper<RootDO> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        RootDO userDO = userMapper.selectOne(wrapper);
        BeanUtils.copyProperties(userDO, userVO);
        return ResultUtil.success(userVO);
    }

}
