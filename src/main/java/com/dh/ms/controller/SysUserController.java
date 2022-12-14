package com.dh.ms.controller;

import com.dh.ms.common.result.Result;
import com.dh.ms.pojo.vo.user.UserLoginVO;
import com.dh.ms.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class SysUserController {
    @Autowired
    private SysUserService userService;

    @GetMapping("/me")
    public Result<UserLoginVO> getUserLoginInfo(){
        UserLoginVO userLoginInfo = this.userService.getUserLoginInfo();
        return Result.success(userLoginInfo);
    }
}
