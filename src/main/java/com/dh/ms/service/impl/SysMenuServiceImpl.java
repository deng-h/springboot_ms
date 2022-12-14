package com.dh.ms.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.common.constant.SystemConstants;
import com.dh.ms.common.enums.MenuTypeEnum;
import com.dh.ms.common.enums.StatusEnum;
import com.dh.ms.pojo.bo.RouteBO;
import com.dh.ms.pojo.entity.SysMenu;
import com.dh.ms.pojo.vo.menu.ResourceVO;
import com.dh.ms.pojo.vo.menu.RouteVO;
import com.dh.ms.service.SysMenuService;
import com.dh.ms.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        return this.baseMapper.listRolePerms(roles);
    }

    @Override
    public List<ResourceVO> listResources() {
        return null;
    }

    @Override
    public List<RouteVO> listRoutes() {
        List<RouteBO> menuList = this.baseMapper.listRoutes();
        List<RouteVO> routeList = recurRoutes(SystemConstants.ROOT_NODE_ID, menuList);
        return routeList;
    }

    /**
     * 递归生成菜单路由层级列表
     *
     * @param parentId 父级ID
     * @param menuList 菜单列表
     * @return
     */
    private List<RouteVO> recurRoutes(Long parentId, List<RouteBO> menuList) {
        List<RouteVO> list = new ArrayList<>();
        Optional.ofNullable(menuList).ifPresent(menus -> menus.stream()
                .filter(menu -> menu.getParentId().equals(parentId))
                .forEach(menu -> {
                    RouteVO routeVO = new RouteVO();

                    MenuTypeEnum menuTypeEnum = menu.getType();

                    if (MenuTypeEnum.MENU.equals(menuTypeEnum)) {
                        routeVO.setName(menu.getPath()); //  根据name路由跳转 this.$router.push({name:xxx})
                    }
                    routeVO.setPath(menu.getPath()); // 根据path路由跳转 this.$router.push({path:xxx})
                    routeVO.setRedirect(menu.getRedirectUrl());
                    routeVO.setComponent(menu.getComponent());

                    RouteVO.Meta meta = new RouteVO.Meta();
                    meta.setTitle(menu.getName());
                    meta.setIcon(menu.getIcon());
                    meta.setRoles(menu.getRoles());
                    meta.setHidden(StatusEnum.DISABLE.getValue().equals(menu.getVisible()));
                    meta.setKeepAlive(true);

                    routeVO.setMeta(meta);
                    List<RouteVO> children = recurRoutes(menu.getId(), menuList);
                    // 含有子节点的目录设置为可见
                    boolean alwaysShow = CollectionUtil.isNotEmpty(children) && children.stream().anyMatch(item -> item.getMeta().getHidden().equals(false));
                    meta.setAlwaysShow(alwaysShow);
                    routeVO.setChildren(children);

                    list.add(routeVO);
                }));
        return list;
    }
}




