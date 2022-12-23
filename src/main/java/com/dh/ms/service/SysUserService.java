package com.dh.ms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.pojo.bo.UserAuthInfo;
import com.dh.ms.pojo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.pojo.form.UserForm;
import com.dh.ms.pojo.query.UserPageQuery;
import com.dh.ms.pojo.vo.user.UserLoginVO;
import com.dh.ms.pojo.vo.user.UserVO;

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

    IPage<UserVO> listUserPages(UserPageQuery queryParams);

    UserForm getUserFormData(Long userId);

    boolean saveUser(UserForm userForm);

    boolean updateUser(Long userId, UserForm userForm);

    boolean updatePassword(Long userId, String password);

    boolean deleteUsers(String ids);
}