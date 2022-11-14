package com.dh.ms.controller;

import com.dh.ms.form.RuleForm;
import com.dh.ms.service.UserService;
import com.dh.ms.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin
public class LoginController {

    @Autowired
    private UserService userService;

    //后端是以实体类接收前端发送的JSON数据，JSON数据是放在post请求体中的，而我们是以实体类接收就会收不到数据
    //解决方法是加@RequestBody注解来将JSON数据封装给JavaBean类型，此时实体类中的属性名要和JSON数据中的属性名要一致
    @PostMapping("/login")
    public ResultVO login(@RequestBody RuleForm ruleForm){
        return this.userService.login(ruleForm);
    }
}
