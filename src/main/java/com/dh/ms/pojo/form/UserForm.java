package com.dh.ms.pojo.form;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * 用户表单对象
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    private Long id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "昵称不能为空")
    private String nickname;

    @Pattern(regexp = "^1(3\\d|4[5-9]|5[0-35-9]|6[2567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$", message = "{phone.valid}")
    private String mobile;

    private Integer gender;

    private String avatar;

    private String email;

    private Integer status;

    private Long deptId;

    @NotEmpty(message = "用户角色不能为空")
    private List<Long> roleIds;

}

