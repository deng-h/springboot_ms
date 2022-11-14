package com.dh.ms.controller;

import com.dh.ms.service.PedalFixedParamService;
import com.dh.ms.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedal_fixed")
@CrossOrigin
public class PedalFixedController {

    @Autowired
    private PedalFixedParamService pedalFixedParamService;

    @GetMapping("/page")
    public ResultVO page(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        return this.pedalFixedParamService.page(pageNum, pageSize);
    }

}
