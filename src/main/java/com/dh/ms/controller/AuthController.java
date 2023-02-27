package com.dh.ms.controller;

import com.dh.ms.common.result.Result;
import com.dh.ms.log.anno.LoginLog;
import com.dh.ms.security.jwt.JwtTokenManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Api(tags = "认证管理")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenManager jwtTokenManager;

    @LoginLog
    @ApiOperation(value = "登录",notes = "生成token")
    @PostMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        // 进行用户认证
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenManager.createToken(authentication);
        return Result.success("Bearer " + token);
    }

    @ApiOperation(value = "注销")
    @DeleteMapping("/logout")
    public Result logout() {
        SecurityContextHolder.clearContext();
        return Result.success("注销成功");
    }
}
