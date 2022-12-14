package com.dh.ms.service;

import com.dh.ms.pojo.bo.UserAuthInfo;
import com.dh.ms.pojo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.pojo.vo.user.UserLoginVO;

/**
* @author dell
* @description 针对表【sys_user(用户信息表)】的数据库操作Service
* @createDate 2022-12-12 13:56:01
*/

/*
* 用户业务接口
*
*/
public interface SysUserService extends IService<SysUser> {

    UserLoginVO getUserLoginInfo();  // 获取登录用户信息

    UserAuthInfo getUserAuthInfo(String username);  // 根据用户名获取认证信息 用于SysUserDetailsServiceImpl认证
}