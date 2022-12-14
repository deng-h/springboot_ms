package com.dh.ms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * 角色和菜单关联表
 * @TableName sys_role_menu
 */
@TableName(value ="sys_role_menu")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleMenu implements Serializable {
    /**
     * 角色ID
     */
    @TableField(value = "role_id")
//    @TableId can't more than one in Class
    private Long roleId;

    /**
     * 菜单ID
     */
    @TableField(value = "menu_id")
    //    @TableId can't more than one in Class
    private Long menuId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysRoleMenu other = (SysRoleMenu) that;
        return (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()));
    }
}