package com.waste.my.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waste.my.domain.GoodsModel;
import com.waste.my.mapper.GoodsDo;
import com.waste.my.mapper.GoodsMapper;
import com.waste.my.util.Result;
import com.waste.my.util.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

/**
 * @Author wykun
 * @Date 2022/3/27 14:55
 */
@Service
public class GoodService {

    @Autowired
    private GoodsMapper goodsMapper;


    public Result createGoods(GoodsModel goodsModel) {
        GoodsDo goodsDo = new GoodsDo();
        BeanUtils.copyProperties(goodsModel, goodsDo);
        int insert = goodsMapper.insert(goodsDo);
        if (insert > 0) {
            return ResultUtil.success();
        }
        return ResultUtil.failed("创建失败");
    }

    public Result queryGoodsList() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("delete_flag", 0);
        List<GoodsDo> list = goodsMapper.selectList(wrapper);
        return ResultUtil.success(list);
    }

    public Result deleteGoods(Long id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        GoodsDo goodsDo = new GoodsDo();
        goodsDo.setDeleteFlag(1);
        goodsDo.setId(id);
        int i = goodsMapper.updateById(goodsDo);
        if (i > 0) {
            return ResultUtil.success(i);
        }
        return ResultUtil.failed("删除失败");
    }

    public Result queryOne(Long id){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        GoodsDo goodsDo = goodsMapper.selectOne(wrapper);
        return ResultUtil.success(goodsDo);
    }

    public Result updateGood(GoodsModel goodsModel){
        GoodsDo goodsDo=new GoodsDo();
        BeanUtils.copyProperties(goodsModel,goodsDo);
        int i = goodsMapper.updateById(goodsDo);
        if (i > 0) {
            return ResultUtil.success(i);
        }
        return ResultUtil.failed("更新失败");
    }
}
