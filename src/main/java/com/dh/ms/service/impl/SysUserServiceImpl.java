package com.dh.ms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.pojo.entity.SysUser;
import com.dh.ms.service.SysUserService;
import com.dh.ms.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author dell
* @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
* @createDate 2022-12-12 13:56:01
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}




