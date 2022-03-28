package com.waste.my.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waste.my.domain.OrderModel;
import com.waste.my.mapper.OrderDO;
import com.waste.my.mapper.OrderMapper;
import com.waste.my.util.NumberUtil;
import com.waste.my.util.Result;
import com.waste.my.util.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wykun
 * @Date 2022/3/27 18:43
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public Result queryList(){
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("delete_flag",0);
        List list = orderMapper.selectList(wrapper);
        return ResultUtil.success(list);
    }

    public Result create(OrderModel orderModel){
        OrderDO orderDO=new OrderDO();
        BeanUtils.copyProperties(orderModel,orderDO);
        orderDO.setOrderCode(NumberUtil.dateRandom16());
        int insert = orderMapper.insert(orderDO);
        if (insert > 0) {
            return ResultUtil.success();
        }
        return ResultUtil.failed("创建失败");
    }

    public Result delete(Long id){
       OrderDO orderDO=new OrderDO();
       orderDO.setId(id);
       orderDO.setDeleteFlag(1);
        int insert = orderMapper.updateById(orderDO);
        if (insert > 0) {
            return ResultUtil.success();
        }
        return ResultUtil.failed("删除失败");
    }
}
