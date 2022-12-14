package com.dh.ms.mapper;

import com.dh.ms.pojo.bo.UserAuthInfo;
import com.dh.ms.pojo.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author dell
* @description 针对表【sys_user(用户信息表)】的数据库操作Mapper
* @createDate 2022-12-12 13:56:01
* @Entity com.dh.ms.pojo/entity.SysUser
*/
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    UserAuthInfo getUserAuthInfo(String username);  // 根据用户名获取认证信息
}




