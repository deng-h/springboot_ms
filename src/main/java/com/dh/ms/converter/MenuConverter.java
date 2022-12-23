package com.dh.ms.converter;

import com.dh.ms.pojo.entity.SysMenu;
import com.dh.ms.pojo.vo.menu.MenuVO;
import org.mapstruct.Mapper;

/**
 * 菜单对象转换器
 */
@Mapper(componentModel = "spring")  // 自动生成这个接口的实现类
public interface MenuConverter {
    MenuVO entity2VO(SysMenu entity);
}
