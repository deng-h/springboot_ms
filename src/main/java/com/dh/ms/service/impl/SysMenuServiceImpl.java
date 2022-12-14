package com.dh.ms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.pojo.entity.SysMenu;
import com.dh.ms.service.SysMenuService;
import com.dh.ms.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
* @author dell
* @description 针对表【sys_menu(菜单管理)】的数据库操作Service实现
* @createDate 2022-12-12 14:21:19
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService{

    @Override
    public Set<String> listRolePerms(Set<String> roles) {
        return null;
    }
}




