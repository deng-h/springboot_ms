package com.dh.ms.midProduct.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.common.result.PageResult;
import com.dh.ms.common.result.Result;
import com.dh.ms.mapper.midProduct.InitProductStorageMapper;
import com.dh.ms.midProduct.bo.InitProdStorageBO;
import com.dh.ms.midProduct.entity.InitProductStorage;
import com.dh.ms.midProduct.query.InitProductStorageQuery;
import com.dh.ms.midProduct.service.InitProductStorageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/midproduct/initprodstorage")
@RestController
public class InitProductStorageController {

    @Autowired
    private InitProductStorageService initProductStorageService;

    @Autowired
    private InitProductStorageMapper initProductStorageMapper;

    @ApiOperation(value = "分页")
    @GetMapping("/storagePages")
    public PageResult<InitProdStorageBO> listMidProdInitProdPages(InitProductStorageQuery query){
        IPage<InitProdStorageBO> pages = initProductStorageService.listMidProdInitProdPages(query);
        return PageResult.success(pages);
    }

    @ApiOperation(value = "库存详情")
    @GetMapping("/{id}")
    public Result getMidProdInitProdDetailById(@PathVariable String id){
        InitProdStorageBO result = initProductStorageMapper.getMidProdInitProdDetailById(id);
        return Result.success(result);
    }

    @ApiOperation(value = "修改库存信息")
    @PutMapping
    public Result updateMidProdInitProd(@RequestBody InitProdStorageBO initProductStorageBO){
        boolean b = initProductStorageService.updateMidProdInitProd(initProductStorageBO);
        return Result.judge(b);
    }
}
