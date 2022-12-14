package com.dh.ms.service;

import com.dh.ms.pojo.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
* @author dell
* @description 针对表【sys_role(角色表)】的数据库操作Service
* @createDate 2022-12-12 14:19:30
*/
public interface SysRoleService extends IService<SysRole> {
    Set<String> selectCodeById(long id);
}
