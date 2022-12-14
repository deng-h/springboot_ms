package com.dh.ms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * 用户和角色关联表
 * @TableName sys_user_role
 */
@TableName(value ="sys_user_role")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SysUserRole implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "user_id")
    //    @TableId can't more than one in Class
    private Long userId;

    /**
     * 角色ID
     */
//    @TableId(value = "role_id")
    //    @TableId can't more than one in Class
    private Long roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}