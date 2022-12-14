package com.dh.ms.service;

import com.dh.ms.pojo.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
* @author dell
* @description 针对表【sys_menu(菜单管理)】的数据库操作Service
* @createDate 2022-12-12 14:21:19
*/

/**
 * 菜单业务接口
 *
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 获取角色权限集合
     */
    Set<String> listRolePerms(Set<String> roles);
}
