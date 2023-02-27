package com.dh.ms.pojo.vo.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.util.Date;

//用户分页视图对象
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVO {
    // 将后端数据值转为字符串类型返回给前端
    @JsonSerialize(using = ToStringSerializer.class)
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
