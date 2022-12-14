package com.dh.ms.pojo.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dh.ms.common.enums.MenuTypeEnum;
import lombok.*;

import java.util.List;

// 路由
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RouteBO {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parentId;  // 父菜单ID

    private String name;  // 菜单名称

    private MenuTypeEnum type;  // 菜单类型(1-菜单；2-目录；3-外链；4-按钮权限)

    private String path;  // 路由路径(浏览器地址栏路径)

    private String component;  // 组件路径(vue页面完整路径，省略.vue后缀)

    private String perm;  // 权限标识

    private Integer visible;  // 显示状态(1:显示;0:隐藏)

    private Integer sort;  // 排序

    private String icon;  // 菜单图标

    private String redirectUrl;  // 外链路径

    private List<String> roles;  // 拥有路由的权限
}
