package com.dh.ms.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectPage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dh.ms.pojo.PedalFixedParam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author dell
* @description 针对表【pedal_fixed_param(踏板固定参数表)】的数据库操作Mapper
* @createDate 2022-11-05 10:39:51
* @Entity com.dh.ms.pojo.PedalFixedParam
*/
@Repository
public interface PedalFixedParamMapper extends BaseMapper<PedalFixedParam> {

}




