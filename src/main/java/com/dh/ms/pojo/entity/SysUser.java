package com.dh.ms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.*;

/**
 * 用户信息表
 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {

    @TableId(value = "id")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 性别((1:男;2:女))
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 部门ID
     */
    @TableField(value = "dept_id")
    private Integer deptId;

    /**
     * 用户头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 联系方式
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 用户状态((1:正常;0:禁用))
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 用户邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 逻辑删除标识(0:未删除;1:已删除)
     */
    @TableField(value = "deleted")
    private Integer deleted;

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