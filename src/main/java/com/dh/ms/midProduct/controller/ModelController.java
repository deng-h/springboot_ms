package com.dh.ms.midProduct.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.common.result.PageResult;
import com.dh.ms.common.result.Result;
import com.dh.ms.midProduct.bo.ModelAndCategoryNameBO;
import com.dh.ms.midProduct.entity.MidProductModel;
import com.dh.ms.midProduct.query.MidProdModelQuery;
import com.dh.ms.midProduct.service.MidProductModelService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/midproduct/model")
@RestController
public class ModelController {
    @Autowired
    private MidProductModelService midProductModelService;

    @ApiOperation(value = "分页")
    @GetMapping("/modelPages")
    public PageResult<MidProductModel> listMidProdModelPages(MidProdModelQuery query){
        IPage<MidProductModel> pages = midProductModelService.listMidProdModelPages(query);
        return PageResult.success(pages);
    }

    @ApiOperation(value = "产品详情")
    @GetMapping("/{modelId}")
    public Result getMidProdModelDetail(@ApiParam("产品ID") @PathVariable String modelId){
        MidProductModel result = midProductModelService.getById(modelId);
        return Result.success(result);
    }

    @ApiOperation(value = "新增产品")
    @PostMapping
    public Result addMidProdModel(@RequestBody MidProductModel model){
        return midProductModelService.addMidProdModel(model);
    }

    @ApiOperation(value = "修改产品")
    @PutMapping
    public Result updateMidProdModel(@RequestBody MidProductModel model){
        boolean b = midProductModelService.updateMidProdModel(model);
        return Result.judge(b);
    }

    @ApiOperation(value = "删除产品")
    @DeleteMapping("/{ids}")
    public Result deleteMidProdModel(@ApiParam("删除，多个以英文逗号(,)分割") @PathVariable String ids){
        boolean b = midProductModelService.deleteMidProdModel(ids);
        return Result.judge(b);
    }

    @ApiOperation(value = "根据产品名得到分组名和产品")
    @GetMapping("/modelAndCategoryNameByModel")
    public Result getModelAndCategoryNameByModel(@RequestParam String model){
        ModelAndCategoryNameBO res = midProductModelService.getModelAndCategoryNameByModel(model);
        return Result.success(res);
    }
}
