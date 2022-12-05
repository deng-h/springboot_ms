package com.dh.ms.controller;

import com.dh.ms.form.RuleForm;
import com.dh.ms.service.UserService;
import com.dh.ms.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResultVO addUser(@RequestBody RuleForm ruleForm){
        return this.userService.addUser(ruleForm);
    }

    @DeleteMapping("/{id}")
    public ResultVO deleteUserByName(@PathVariable("id") String id){
        return this.userService.deleteUserByID(id);
    }

    @GetMapping
    public ResultVO getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/{name}/{userType}")
    public ResultVO queryUser(@PathVariable("name") String name, @PathVariable("userType") String userType){
        return this.userService.queryUser(name, userType);
    }

    @PostMapping ("/update")
    public ResultVO updateUserByID(@RequestBody RuleForm ruleForm){
        return this.userService.updateUser(ruleForm);
    }
}