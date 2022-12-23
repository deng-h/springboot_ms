package com.dh.ms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dh.ms.common.model.Option;
import com.dh.ms.pojo.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.pojo.form.RoleForm;
import com.dh.ms.pojo.query.RolePageQuery;
import com.dh.ms.pojo.vo.role.RolePageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
* @author dell
* @description 针对表【sys_role(角色表)】的数据库操作Service
* @createDate 2022-12-12 14:19:30
*/
public interface SysRoleService extends IService<SysRole> {
    Set<String> selectCodeById(long id);

    List<Option> listRoleOptions();

    Page<RolePageVO> listRolePages(RolePageQuery queryParams);

    boolean saveRole(RoleForm roleForm);

    boolean deleteRoles(String ids);

    boolean updateRoleMenus(Long roleId, List<Long> menuIds);

    List<Long> getRoleMenuIds(Long roleId);
}
