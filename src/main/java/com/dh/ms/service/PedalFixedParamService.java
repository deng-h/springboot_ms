package com.dh.ms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.pojo.entity.PedalFixedParam;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.pojo.query.PedalPageQuery;

/**
* @author dell
* @description 针对表【pedal_fixed_param(踏板固定参数表)】的数据库操作Service
* @createDate 2022-12-20 20:13:12
*/
public interface PedalFixedParamService extends IService<PedalFixedParam> {
    public IPage<PedalFixedParam> listFixedParamPages(PedalPageQuery queryParams);
}
