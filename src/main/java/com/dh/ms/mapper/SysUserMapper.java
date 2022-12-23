package com.dh.ms.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dh.ms.pojo.bo.UserAuthInfo;
import com.dh.ms.pojo.bo.UserBO;
import com.dh.ms.pojo.bo.UserFormBO;
import com.dh.ms.pojo.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dh.ms.pojo.query.UserPageQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    UserAuthInfo getUserAuthInfo(String username);  // 根据用户名获取认证信息

    Page<UserBO> listUserPages(Page<UserBO> page, UserPageQuery queryParams);  // 获取用户分页列表

    UserFormBO getUserDetail(Long userId);
}




