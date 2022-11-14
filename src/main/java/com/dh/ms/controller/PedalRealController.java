package com.dh.ms.controller;

import com.dh.ms.service.PedalRealParamService;
import com.dh.ms.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedal_real")
@CrossOrigin
public class PedalRealController {
    @Autowired
    private PedalRealParamService pedalRealParamService;

    @GetMapping("/page")
    public ResultVO page(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        return this.pedalRealParamService.page(pageNum, pageSize);
    }
}