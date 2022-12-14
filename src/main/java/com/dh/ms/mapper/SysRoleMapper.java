package com.dh.ms.mapper;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.dh.ms.pojo.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author dell
* @description 针对表【sys_role(角色表)】的数据库操作Mapper
* @createDate 2022-12-12 14:19:30
* @Entity com.dh.ms.pojo.entity.SysRole
*/
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    Set<String> selectCodeById(@Param("id") Long id);
}




