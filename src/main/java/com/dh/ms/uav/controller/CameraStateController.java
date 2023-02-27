package com.dh.ms.uav.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.common.result.PageResult;
import com.dh.ms.common.result.Result;
import com.dh.ms.uav.entity.UavCameraState;
import com.dh.ms.uav.form.CameraStateForm;
import com.dh.ms.uav.query.CameraStateQuery;
import com.dh.ms.uav.service.UavCameraStateService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/uav/pathplan")
public class CameraStateController {

    @Autowired
    private UavCameraStateService uavCameraStateService;

    @GetMapping("/camerasPages")
    public PageResult<UavCameraState> listCameraStatePages(CameraStateQuery query){
        IPage<UavCameraState> pages = uavCameraStateService.listCameraStatePages(query);
        return PageResult.success(pages);
    }

    @DeleteMapping("/deleteCameraState/{ids}")
    public Result deleteCameraState(@ApiParam("删除，多个以英文逗号(,)分割") @PathVariable String ids){
        System.out.println("controller"+ids);
        boolean b = uavCameraStateService.deleteCameraState(ids);
        return Result.judge(b);
    }

    @PostMapping("/addCameraState")
    public Result addCameraState(@RequestBody @Valid CameraStateForm cameraStateForm){
        boolean b = uavCameraStateService.addCameraState(cameraStateForm);
        return Result.judge(b);
    }

    @PutMapping("/updateCameraState")
    public Result updateCameraState(@RequestBody @Valid CameraStateForm cameraStateForm){
        boolean b = uavCameraStateService.updateCameraState(cameraStateForm);
        return Result.judge(b);
    }
}
