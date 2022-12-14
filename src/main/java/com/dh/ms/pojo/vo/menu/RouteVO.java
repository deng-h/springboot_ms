package com.dh.ms.pojo.vo.menu;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

/**
 * 菜单路由视图对象
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RouteVO {

    private String path;

    private String component;

    private String redirect;

    private String name;

    private Meta meta;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Meta {

        private String title;

        private String icon;

        private Boolean hidden;

        private Boolean alwaysShow;  // 如果设置为 true，目录没有子节点也会显示

        private List<String> roles;

        private Boolean keepAlive;  // 页面缓存开启状态
    }
    private List<RouteVO> children;
}

