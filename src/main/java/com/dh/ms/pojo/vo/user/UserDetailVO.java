package com.dh.ms.pojo.vo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//用户表详情视图对象
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailVO {
    private Long id;

    private String username;

    private String nickname;

    private String mobile;

    private Integer gender;

    private String avatar;

    private String email;

    private Integer status;

    private Long deptId;

    private List<Long> roleIds;
}
