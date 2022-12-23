package com.dh.ms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.pojo.entity.PedalFixedParam;
import com.dh.ms.pojo.entity.PedalRealParam;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.pojo.query.PedalPageQuery;

/**
* @author dell
* @description 针对表【pedal_real_param(踏板实时参数表)】的数据库操作Service
* @createDate 2022-12-20 20:13:27
*/
public interface PedalRealParamService extends IService<PedalRealParam> {
    public IPage<PedalRealParam> listRealParamPages(PedalPageQuery queryParams);
}
