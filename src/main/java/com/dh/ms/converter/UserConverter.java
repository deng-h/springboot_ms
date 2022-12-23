package com.dh.ms.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dh.ms.pojo.bo.UserBO;
import com.dh.ms.pojo.bo.UserFormBO;
import com.dh.ms.pojo.entity.SysUser;
import com.dh.ms.pojo.form.UserForm;
import com.dh.ms.pojo.vo.user.UserLoginVO;
import com.dh.ms.pojo.vo.user.UserVO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//用户对象转换器
@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mappings({
            @Mapping(target = "genderLabel", expression = "java(com.dh.ms.common.base.IBaseEnum.getLabelByValue(po.getGender(), com.dh.ms.common.enums.GenderEnum.class))")
    })
    UserVO po2Vo(UserBO po);

    Page<UserVO> po2Vo(Page<UserBO> po);

    UserForm po2Form(UserFormBO po);

    UserForm entity2Form(SysUser entity);

    @InheritInverseConfiguration(name = "entity2Form")
    SysUser form2Entity(UserForm entity);

    @Mappings({@Mapping(target = "userId", source = "id")})
    UserLoginVO entity2LoginUser(SysUser entity);
}
