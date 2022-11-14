package com.dh.ms.controller;

import com.dh.ms.form.RuleForm;
import com.dh.ms.service.UserService;
import com.dh.ms.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResultVO addUser(@RequestBody RuleForm ruleForm){
        return this.userService.addUser(ruleForm);
    }

    @GetMapping("/delete")
    public ResultVO deleteUserByName(String id){
        return this.userService.deleteUserByID(id);
    }

    @GetMapping("/all")
    public ResultVO getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/query")
    public ResultVO queryUser(@RequestParam String name, @RequestParam String userType){
        return this.userService.queryUser(name, userType);
    }

    @PostMapping ("/update")
    public ResultVO updateUserByID(@RequestBody RuleForm ruleForm){
        return this.userService.updateUser(ruleForm);
    }
}