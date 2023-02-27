package com.dh.ms.midProduct.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.common.result.PageResult;
import com.dh.ms.midProduct.bo.MidPlanSettingBO;
import com.dh.ms.midProduct.query.MidProdPlanQuery;
import com.dh.ms.midProduct.service.MidProductPlansettingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/midproduct/plansetting")
@RestController
public class PlanSettingController {
    @Autowired
    private MidProductPlansettingService midProductPlansettingService;

    @ApiOperation(value = "分页")
    @GetMapping("/planPages")
    public PageResult<MidPlanSettingBO> listMidProdPlanPages(MidProdPlanQuery query){
        IPage<MidPlanSettingBO> pages = midProductPlansettingService.listMidProdPlanPages(query);
        return PageResult.success(pages);
    }
}
