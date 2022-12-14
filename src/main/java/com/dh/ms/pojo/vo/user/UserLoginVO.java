package com.dh.ms.pojo.vo.user;

import lombok.*;

import java.util.Set;

/**
 * 用户登录视图对象
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVO {

    private Long userId;

    private String nickname;

    private String avatar;

    private Set<String> roles;

    private Set<String> perms;
}
