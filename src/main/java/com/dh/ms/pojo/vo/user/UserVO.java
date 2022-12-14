package com.dh.ms.pojo.vo.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

//用户分页视图对象
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Long id;

    private String username;

    private String nickname;

    private String mobile;

    private String genderLabel;

    private String avatar;

    private String email;

    private Integer status;

    private String deptName;

    private String roleNames;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}
