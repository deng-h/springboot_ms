package com.dh.ms.mapper.system;

import com.dh.ms.pojo.bo.RouteBO;
import com.dh.ms.pojo.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
* @author dell
* @description 针对表【sys_menu(菜单管理)】的数据库操作Mapper
* @createDate 2022-12-12 14:21:19
* @Entity com.dh.ms.pojo.entity.SysMenu
*/
@Repository
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    Set<String> listRolePerms(@Param("roles")Set<String> roles);  // 获取角色权限集合
    List<RouteBO> listRoutes();  // 获取路由列表
}




