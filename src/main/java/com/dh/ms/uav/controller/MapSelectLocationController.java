package com.dh.ms.uav.controller;

import com.dh.ms.common.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/uav/pathplan")
@RestController
public class MapSelectLocationController {

    @PostMapping("/flight")
    public Result addUavPath(@RequestParam("uavID") String uavID,
                             @RequestParam("longitude") String longitude,
                             @RequestParam("latitude") String latitude){
        System.out.println(longitude);
        System.out.println(latitude);
        System.out.println(uavID);
        return Result.success("成功");
    }

    @ApiOperation(value = "响应前端获取无人机当前位置的请求")
    @GetMapping("/getLocation")
    public Result getUavLocation(@RequestParam("uavID") String uavID){
        return Result.success("成功");
    }
}
