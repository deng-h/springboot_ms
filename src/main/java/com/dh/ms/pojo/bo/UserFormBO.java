package com.dh.ms.pojo.bo;

import lombok.*;

import java.util.List;

/**
 * user表单持久化对象
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserFormBO {

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

