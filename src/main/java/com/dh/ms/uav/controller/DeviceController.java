package com.dh.ms.uav.controller;


import com.dh.ms.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/device")
@RestController
public class DeviceController {

    @GetMapping("/gxpe63_host1/gxpe63Host1Pages")
    public Result listGxPe3Host1Pages(){
        return Result.success();
    }
}
