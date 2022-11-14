package com.dh.ms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.pojo.PedalFixedParam;
import com.dh.ms.pojo.PedalRealParam;
import com.dh.ms.service.PedalRealParamService;
import com.dh.ms.mapper.PedalRealParamMapper;
import com.dh.ms.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author dell
* @description 针对表【pedal_real_param(踏板实时参数表)】的数据库操作Service实现
* @createDate 2022-11-05 21:07:47
*/
@Service
public class PedalRealParamServiceImpl extends ServiceImpl<PedalRealParamMapper, PedalRealParam> implements PedalRealParamService{

    @Autowired
    private PedalRealParamMapper pedalRealParamMapper;

    @Override
    public ResultVO page(Integer pageNum, Integer pageSize) {
        ResultVO resultVO = new ResultVO();
        Map<String, Object> map = new HashMap<>();
        Page<PedalRealParam> page = new Page<>(pageNum, pageSize);
        this.pedalRealParamMapper.selectPage(page, null);
        List<PedalRealParam> list = page.getRecords();
        long total = page.getTotal();
        map.put("data", list);
        map.put("total", total);
        resultVO = ResultVO.success(null,map);
        return resultVO;
    }
}




