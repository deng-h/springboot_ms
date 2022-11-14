package com.dh.ms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.pojo.PedalFixedParam;
import com.dh.ms.service.PedalFixedParamService;
import com.dh.ms.mapper.PedalFixedParamMapper;
import com.dh.ms.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author dell
* @description 针对表【pedal_fixed_param(踏板固定参数表)】的数据库操作Service实现
* @createDate 2022-11-05 10:39:51
*/
@Service
public class PedalFixedParamServiceImpl extends ServiceImpl<PedalFixedParamMapper, PedalFixedParam> implements PedalFixedParamService{

    @Autowired
    private PedalFixedParamMapper pedalFixedParamMapper;

    @Override
    public ResultVO page(Integer pageNum, Integer pageSize) {
        ResultVO resultVO = new ResultVO();
        Map<String, Object> map = new HashMap<>();
        Page<PedalFixedParam> page = new Page<>(pageNum, pageSize);
        this.pedalFixedParamMapper.selectPage(page, null);
        List<PedalFixedParam> list = page.getRecords();
        System.out.println();
        long total = page.getTotal();
        map.put("data", list);
        map.put("total", total);
        resultVO = ResultVO.success(null,map);
        return resultVO;
    }
}




