package com.dh.ms.service;

import com.dh.ms.pojo.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author dell
* @description 针对表【sys_user_role(用户和角色关联表)】的数据库操作Service
* @createDate 2022-12-12 14:22:13
*/
public interface SysUserRoleService extends IService<SysUserRole> {

    /**
     * 保存用户角色
     *
     * @param userId
     * @param roleIds
     * @return
     */
    boolean saveUserRoles(Long userId, List<Long> roleIds);
}
