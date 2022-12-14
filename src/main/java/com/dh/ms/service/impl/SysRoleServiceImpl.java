package com.dh.ms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.pojo.entity.SysRole;
import com.dh.ms.service.SysRoleService;
import com.dh.ms.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
* @author dell
* @description 针对表【sys_role(角色表)】的数据库操作Service实现
* @createDate 2022-12-12 14:19:30
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService{

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public Set<String> selectCodeById(long id) {
        return this.roleMapper.selectCodeById(id);
    }
}




