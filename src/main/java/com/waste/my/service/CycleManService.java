package com.waste.my.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waste.my.domain.CycleManModel;
import com.waste.my.mapper.CycleManDO;
import com.waste.my.mapper.CycleManMapper;
import com.waste.my.util.GenerateUserId;
import com.waste.my.util.Result;
import com.waste.my.util.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wykun
 * @Date 2022/3/28 22:05
 */
@Service
public class CycleManService {

    @Autowired
    private CycleManMapper cycleManMapper;

    public Result create(CycleManModel cycleManModel){
        CycleManDO cycleManDO=new CycleManDO();
        BeanUtils.copyProperties(cycleManModel,cycleManDO);
        cycleManDO.setUserCode(GenerateUserId.generate());
        int insert = cycleManMapper.insert(cycleManDO);
        if(insert>0){
            return ResultUtil.success();
        }
        return ResultUtil.failed("创建失败");
    }

    public Result queryList(){
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("delete_flag",0);
        List list = cycleManMapper.selectList(wrapper);
        return ResultUtil.success(list);
    }

    public Result delete(long id){
        CycleManDO cycleManDO=new CycleManDO();
        cycleManDO.setId(id);
        cycleManDO.setDeleteFlag(1);
        int delete = cycleManMapper.updateById(cycleManDO);
        if(delete>0){
            return ResultUtil.success();
        }
        return ResultUtil.failed("删除失败");
    }

    public Result update(CycleManModel cycleManModel){
        CycleManDO cycleManDO=new CycleManDO();
        BeanUtils.copyProperties(cycleManModel,cycleManDO);
        int update = cycleManMapper.updateById(cycleManDO);
        if(update>0){
            return ResultUtil.success();
        }
        return ResultUtil.failed("更新失败");
    }

    public Result queryOne(Long id){
       QueryWrapper wrapper=new QueryWrapper();
       wrapper.eq("id",id);
        CycleManDO cycleManDO = cycleManMapper.selectOne(wrapper);
        return ResultUtil.success(cycleManDO);
    }
}
