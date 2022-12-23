package com.dh.ms.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.pojo.entity.PedalRealParam;
import com.dh.ms.pojo.query.PedalPageQuery;
import com.dh.ms.service.PedalRealParamService;
import com.dh.ms.mapper.PedalRealParamMapper;
import org.springframework.stereotype.Service;

/**
* @author dell
* @description 针对表【pedal_real_param(踏板实时参数表)】的数据库操作Service实现
* @createDate 2022-12-20 20:13:27
*/
@Service
public class PedalRealParamServiceImpl extends ServiceImpl<PedalRealParamMapper, PedalRealParam> implements PedalRealParamService{

    /**
     * 获取参数分页列表
     */
    @Override
    public IPage<PedalRealParam> listRealParamPages(PedalPageQuery queryParams) {
        int pageNum = queryParams.getPageNum();
        int pageSize = queryParams.getPageSize();
        // 查询数据
        Page<PedalRealParam> page = this.page(new Page<>(pageNum, pageSize));
        return page;
    }
}




