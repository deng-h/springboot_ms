package com.dh.ms.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.common.result.PageResult;
import com.dh.ms.common.result.Result;
import com.dh.ms.pojo.entity.SysUser;
import com.dh.ms.pojo.form.UserForm;
import com.dh.ms.pojo.query.UserPageQuery;
import com.dh.ms.pojo.vo.user.UserLoginVO;
import com.dh.ms.pojo.vo.user.UserVO;
import com.dh.ms.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "用户接口")
@RestController
@RequestMapping("/users")
public class SysUserController {
    @Autowired
    private SysUserService userService;

    @ApiOperation(value = "获取登录用户信息")
    @GetMapping("/me")
    public Result<UserLoginVO> getUserLoginInfo(){
        UserLoginVO userLoginInfo = userService.getUserLoginInfo();
        return Result.success(userLoginInfo);
    }

    @ApiOperation(value = "用户分页列表")
    @GetMapping("/pages")
    public PageResult<UserVO> listUserPages(UserPageQuery queryParams) {
        IPage<UserVO> result = userService.listUserPages(queryParams);
        return PageResult.success(result);
    }

    @ApiOperation(value = "用户表单数据")
    @GetMapping("/{userId}/form")
    public Result<UserForm> getUserDetail(@ApiParam(value = "用户ID") @PathVariable Long userId) {
        UserForm formData = userService.getUserFormData(userId);
        return Result.success(formData);
    }

    @ApiOperation(value = "新增用户")
    @PostMapping
    @PreAuthorize("hasAuthority('sys:user:add')")
    public Result saveUser(@RequestBody @Valid UserForm userForm) {
        boolean result = userService.saveUser(userForm);
        return Result.judge(result);
    }

    @ApiOperation(value = "修改用户")
    @PutMapping(value = "/{userId}")
    @PreAuthorize("hasAuthority('sys:user:edit')")
    public Result updateUser(@ApiParam("用户ID") @PathVariable Long userId, @RequestBody @Validated UserForm userForm) {
        boolean result = userService.updateUser(userId, userForm);
        return Result.judge(result);
    }

    @ApiOperation(value = "修改用户状态")
    @PatchMapping(value = "/{userId}/status")
    public Result updatePassword(@ApiParam("用户ID") @PathVariable Long userId,
            @ApiParam("用户状态(1:启用;0:禁用)") @RequestParam Integer status) {
        boolean result = userService.update(new LambdaUpdateWrapper<SysUser>()
                .eq(SysUser::getId, userId)
                .set(SysUser::getStatus, status)
        );
        return Result.judge(result);
    }

    @ApiOperation(value = "修改用户密码")
    @PatchMapping(value = "/{userId}/password")
    public Result updatePassword(@ApiParam("用户ID") @PathVariable Long userId, @RequestParam String password) {
        boolean result = userService.updatePassword(userId, password);
        return Result.judge(result);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{ids}")
    @PreAuthorize("hasAuthority('sys:user:delete')")
    public Result deleteUsers(@ApiParam("用户ID，多个以英文逗号(,)分割") @PathVariable String ids) {
        boolean result = userService.deleteUsers(ids);
        return Result.judge(result);
    }
}
