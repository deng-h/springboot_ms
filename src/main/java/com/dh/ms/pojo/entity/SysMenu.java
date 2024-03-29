package com.dh.ms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.*;

/**
 * 菜单管理
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SysMenu implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父菜单ID
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 菜单名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 菜单类型(1:菜单；2:目录；3:外链；4:按钮)
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 路由路径(浏览器地址栏路径)
     */
    @TableField(value = "path")
    private String path;

    /**
     * 组件路径(vue页面完整路径，省略.vue后缀)
     */
    @TableField(value = "component")
    private String component;

    /**
     * 权限标识
     */
    @TableField(value = "perm")
    private String perm;

    /**
     * 显示状态(1-显示;0-隐藏)
     */
    @TableField(value = "visible")
    private Integer visible;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 外链路径
     */
    @TableField(value = "redirect_url")
    private String redirectUrl;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}