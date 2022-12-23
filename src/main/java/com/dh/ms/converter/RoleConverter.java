package com.dh.ms.converter;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dh.ms.common.model.Option;
import com.dh.ms.pojo.entity.SysRole;
import com.dh.ms.pojo.form.RoleForm;
import com.dh.ms.pojo.vo.role.RolePageVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * 角色对象转换器
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {

    Page<RolePageVO> entity2Page(Page<SysRole> page);

    @Mappings({
            @Mapping(target = "value", source = "id"),
            @Mapping(target = "label", source = "name")
    })
    Option role2Option(SysRole role);


    List<Option> roles2Options(List<SysRole> roles);

    SysRole form2Entity(RoleForm roleForm);
}
