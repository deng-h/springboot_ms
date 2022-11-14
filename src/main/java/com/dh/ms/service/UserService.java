package com.dh.ms.service;

import com.dh.ms.form.RuleForm;
import com.dh.ms.form.UserForm;
import com.dh.ms.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.vo.ResultVO;

/**
* @author dell
* @description 针对表【user】的数据库操作Service
* @createDate 2022-11-05 10:40:52
*/
public interface UserService extends IService<User> {
    public ResultVO login(RuleForm ruleForm);

    public ResultVO addUser(RuleForm ruleForm);

    public ResultVO deleteUserByID(String id);

    public ResultVO getAllUsers();

    public ResultVO queryUser(String name, String userType);

    public ResultVO updateUser(RuleForm ruleForm);
}
