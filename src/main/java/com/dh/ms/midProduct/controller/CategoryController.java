package com.dh.ms.midProduct.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.common.result.PageResult;
import com.dh.ms.common.result.Result;
import com.dh.ms.midProduct.entity.MidProductCategory;
import com.dh.ms.midProduct.query.MidProdCategoryQuery;
import com.dh.ms.midProduct.service.MidProductCategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/midproduct/category")
@RestController
public class CategoryController {
    @Autowired
    private MidProductCategoryService midProductCategoryService;

    @ApiOperation(value = "分页")
    @GetMapping("/categoryPages")
    public PageResult<MidProductCategory> listMidProdCategoryPages(MidProdCategoryQuery query){
        IPage<MidProductCategory> pages = midProductCategoryService.listMidProdCategoryPages(query);
        return PageResult.success(pages);
    }

    @ApiOperation(value = "产品分类详情")
    @GetMapping("/{categoryId}")
    public Result getMidProdCategoryDetail(@ApiParam("产品分类ID") @PathVariable String categoryId){
        MidProductCategory result = midProductCategoryService.getById(categoryId);
        return Result.success(result);
    }

    @ApiOperation(value = "修改产品分类")
    @PutMapping(value = "/{categoryId}")
    public Result updateMidProdCategory(@PathVariable String categoryId, @RequestParam("categoryName") String categoryName){
        boolean b = midProductCategoryService.updateMidProdCategory(categoryId, categoryName);
        return Result.judge(b);
    }

    @ApiOperation(value = "新增分类")
    @PostMapping
    public Result addMidProdCategory(@RequestParam("categoryName") String categoryName){
        return midProductCategoryService.addMidProdCategory(categoryName);
    }

    @ApiOperation(value = "删除分类")
    @DeleteMapping("/{ids}")
    public Result deleteMidProdCategory(@ApiParam("删除，多个以英文逗号(,)分割") @PathVariable String ids){
        boolean b = midProductCategoryService.deleteMidProdCategory(ids);
        return Result.judge(b);
    }

    @ApiOperation(value = "获取分类名称，形成列表返回")
    @GetMapping("/categoryNameList")
    public Result getMidProdCategoryNameList(){
        List<Map<String, Object>> listObjects = midProductCategoryService.listMaps(new QueryWrapper<MidProductCategory>()
                .lambda().select(MidProductCategory::getName, MidProductCategory::getId).orderByDesc(MidProductCategory::getGmtModified));
        return Result.success(listObjects);
    }
}
