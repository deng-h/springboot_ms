package com.dh.ms.controller;


import com.dh.ms.common.result.Result;
import com.dh.ms.pojo.vo.menu.RouteVO;
import com.dh.ms.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class SysMenuController {

    @Autowired
    private SysMenuService menuService;

    @GetMapping("/routes")
    public Result listRoutes() {
        List<RouteVO> routeList = menuService.listRoutes();
        return Result.success(routeList);
    }
}
