package com.dh.ms.pojo.bo;

import lombok.*;

import java.util.Set;

/*
* 用户认证信息
* */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAuthInfo {
    private Long userId;

    private String username;

    private String nickname;

    private Integer deptId;

    private String password;

    private Integer status;

    private Long roleId;

    private Set<String> roles;  // 不会使用多表联查 Set集合类型没搞明白

    private Set<String> perms;
}
