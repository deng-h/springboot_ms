package com.dh.ms.service;

import com.dh.ms.common.model.Option;
import com.dh.ms.pojo.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.pojo.query.MenuQuery;
import com.dh.ms.pojo.vo.menu.MenuVO;
import com.dh.ms.pojo.vo.menu.ResourceVO;
import com.dh.ms.pojo.vo.menu.RouteVO;

import java.util.List;
import java.util.Set;

/**
* @author dell
* @description 针对表【sys_menu(菜单管理)】的数据库操作Service
* @createDate 2022-12-12 14:21:19
*/

/**
 * 菜单业务接口
 */
public interface SysMenuService extends IService<SysMenu> {

    Set<String> listRolePerms(Set<String> roles);  // 获取角色权限集合

    List<ResourceVO> listResources();  // 资源(菜单+权限)树形列表

    List<RouteVO> listRoutes();  // 获取路由列表

    List<MenuVO> listMenus(MenuQuery queryParams);  // // 菜单表格树形列表

    List<Option> listMenuOptions();

    boolean saveMenu(SysMenu menu);

    boolean updateMenuVisible(Long menuId, Integer visible);
}
