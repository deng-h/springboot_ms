package com.dh.ms.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleForm {
    private String userName;
    private String password;
    private String userType;
    private String id;
}
