package com.dh.ms.service;

import com.dh.ms.pojo.PedalRealParam;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.vo.ResultVO;

/**
* @author dell
* @description 针对表【pedal_real_param(踏板实时参数表)】的数据库操作Service
* @createDate 2022-11-05 21:07:47
*/
public interface PedalRealParamService extends IService<PedalRealParam> {
    public ResultVO page(Integer pageNum, Integer pageSize);
}
