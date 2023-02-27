package com.dh.ms.midProduct.controller;

import com.dh.ms.common.result.Result;
import com.dh.ms.midProduct.entity.MidProductModel;
import com.dh.ms.midProduct.entity.MidProductTeamdefaulttime;
import com.dh.ms.midProduct.service.MidProductTeamdefaulttimeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/midproduct/teamdefaulttime")
@RestController
public class TeamdefaulttimeController {
    @Autowired
    private MidProductTeamdefaulttimeService midProductTeamdefaulttimeService;

    @ApiOperation(value = "根据teamType查找数据")
    @GetMapping("/{teamType}")
    public Result getDataByTeamType(@ApiParam("teamType") @PathVariable String teamType){
        return midProductTeamdefaulttimeService.getDataByTeamType(teamType);
    }

    @ApiOperation(value = "更新TeamDefaultTime")
    @PutMapping
    public Result updateTeamDefaultTime(@RequestBody MidProductTeamdefaulttime teamDefaultTime){
        boolean b = midProductTeamdefaulttimeService.updateTeamDefaultTime(teamDefaultTime);
        return Result.judge(b);
    }

}
