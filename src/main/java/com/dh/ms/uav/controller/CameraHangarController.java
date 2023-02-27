package com.dh.ms.uav.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.common.result.PageResult;
import com.dh.ms.common.result.Result;
import com.dh.ms.uav.entity.UavCameraHangar;
import com.dh.ms.uav.query.CameraHangarQuery;
import com.dh.ms.uav.service.UavCameraHangarService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/uav/pathplan")
@RestController
public class CameraHangarController {

    @Autowired
    private UavCameraHangarService uavCameraHangarService;

    @GetMapping("/hangarsPages")
    public PageResult<UavCameraHangar> listCameraHangarPages(CameraHangarQuery query){
        IPage<UavCameraHangar> pages = uavCameraHangarService.listCameraHangarPages(query);
        return PageResult.success(pages);
    }

    @PostMapping("/addHangarCategory")
    public Result addCameraHangar(@RequestParam("hangarCategory") String hangarCategory){
        return uavCameraHangarService.addCameraHangar(hangarCategory);
    }

    @DeleteMapping("/deleteCameraHangars/{ids}")
    public Result deleteCameraHangars(@ApiParam("删除，多个以英文逗号(,)分割") @PathVariable String ids){
        boolean b = uavCameraHangarService.deleteCameraHangars(ids);
        return Result.judge(b);
    }

    @ApiOperation(value = "修改分组名称")
    @PutMapping("/updateCameraHangar/{id}")
    public Result updateCameraHangar(@PathVariable String id, @RequestParam("hangarCategory") String hangarCategory){
        boolean b = uavCameraHangarService.updateCameraHangar(id, hangarCategory);
        return Result.judge(b);
    }

    @ApiOperation(value = "获取机库列表")
    @GetMapping("/hangarCategory")
    public Result getHangarCategory(){
        List<UavCameraHangar> hangarCategory = uavCameraHangarService.getHangarCategory();
        return Result.success(hangarCategory);
    }
}
