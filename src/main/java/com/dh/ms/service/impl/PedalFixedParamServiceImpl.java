package com.dh.ms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.pojo.entity.PedalFixedParam;
import com.dh.ms.pojo.entity.SysRole;
import com.dh.ms.pojo.query.PedalPageQuery;
import com.dh.ms.service.PedalFixedParamService;
import com.dh.ms.mapper.PedalFixedParamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author dell
* @description 针对表【pedal_fixed_param(踏板固定参数表)】的数据库操作Service实现
* @createDate 2022-12-20 20:13:12
*/
@Service
public class PedalFixedParamServiceImpl extends ServiceImpl<PedalFixedParamMapper, PedalFixedParam> implements PedalFixedParamService{

    /**
     * 获取参数分页列表
     */
    @Override
    public IPage<PedalFixedParam> listFixedParamPages(PedalPageQuery queryParams) {
        // 查询参数
        int pageNum = queryParams.getPageNum();
        int pageSize = queryParams.getPageSize();
        // 查询数据
        Page<PedalFixedParam> page = this.page(new Page<>(pageNum, pageSize));
        return page;
    }
}




