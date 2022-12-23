package com.dh.ms.mapper;

import com.dh.ms.pojo.entity.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author dell
* @description 针对表【sys_role_menu(角色和菜单关联表)】的数据库操作Mapper
* @createDate 2022-12-12 14:21:50
* @Entity com.dh.ms.pojo.entity.SysRoleMenu
*/
@Repository
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    List<Long> listMenuIdsByRoleId(Long roleId);
}




