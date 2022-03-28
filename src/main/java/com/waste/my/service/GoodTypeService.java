package com.waste.my.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waste.my.mapper.GoodTypeDo;
import com.waste.my.mapper.GoodTypeMapper;
import com.waste.my.util.Result;
import com.waste.my.util.ResultUtil;
import com.waste.my.vo.GoodTypeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wykun
 * @Date 2022/3/27 14:19
 */
@Service
public class GoodTypeService {

    @Autowired
    private GoodTypeMapper goodTypeMapper;

    public Result queryGoodTypeList(){
        List<GoodTypeVo> goodTypeVoList=new ArrayList<>();
        QueryWrapper<GoodTypeDo> wrapper=new QueryWrapper<>();
        wrapper.eq("delete_flag",0);
        List<GoodTypeDo> goodTypeDos = goodTypeMapper.selectList(wrapper);
        for(GoodTypeDo goodTypeDo:goodTypeDos){
            GoodTypeVo goodTypeVo=new GoodTypeVo();
            BeanUtils.copyProperties(goodTypeDo,goodTypeVo);
            goodTypeVoList.add(goodTypeVo);
        }
        return ResultUtil.success(goodTypeVoList);
    }
}
