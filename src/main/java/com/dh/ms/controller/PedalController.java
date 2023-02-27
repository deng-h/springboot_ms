package com.dh.ms.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.common.result.PageResult;
import com.dh.ms.log.anno.BusinessLog;
import com.dh.ms.pojo.entity.PedalFixedParam;
import com.dh.ms.pojo.entity.PedalRealParam;
import com.dh.ms.pojo.query.PedalPageQuery;
import com.dh.ms.service.PedalFixedParamService;
import com.dh.ms.service.PedalRealParamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "踏板参数")
@RestController
@RequestMapping("/pedal")
public class PedalController {

    @Autowired
    private PedalFixedParamService fixedParamService;

    @Autowired
    private PedalRealParamService realParamService;

    @BusinessLog(value = "踏板固定参数分页列表")
    @ApiOperation(value = "踏板固定参数分页列表")
    @GetMapping("/fixed/pages")
    public PageResult<PedalFixedParam> listFixedParamPages(PedalPageQuery queryParams){
        IPage<PedalFixedParam> pedalFixedParamIPage = fixedParamService.listFixedParamPages(queryParams);
        return PageResult.success(pedalFixedParamIPage);
    }

    @ApiOperation(value = "踏板实时参数分页列表")
    @GetMapping("/real/pages")
    public PageResult<PedalRealParam> listRealParamPages(PedalPageQuery queryParams){
        IPage<PedalRealParam> pedalRealParamIPage = realParamService.listRealParamPages(queryParams);
        return PageResult.success(pedalRealParamIPage);
    }
}
