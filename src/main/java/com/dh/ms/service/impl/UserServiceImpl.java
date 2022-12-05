package com.dh.ms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.Utils.JWTUtils;
import com.dh.ms.form.LoginUser;
import com.dh.ms.form.RuleForm;
import com.dh.ms.pojo.User;
import com.dh.ms.service.UserService;
import com.dh.ms.mapper.UserMapper;
import com.dh.ms.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
* @author dell
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-11-05 10:40:52
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResultVO login(RuleForm ruleForm) {
        ResultVO resultVO = new ResultVO();
        //将用户信息封装一下
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(ruleForm.getUsername(),ruleForm.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);  // 进行用户认证

        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }

        Map<String, String> map = new HashMap<>();  // 用来存放payload
        LoginUser loginUser = (LoginUser)authenticate.getPrincipal();
        String id = loginUser.getUser().getId();
        String name = loginUser.getUser().getName();
        map.put("id", id);
        map.put("name", name);
        String token = JWTUtils.getToken(map);  // 生成Token
        resultVO = ResultVO.success("登录成功",token);  // 返回Token
        return resultVO;
    }

    @Override
    public ResultVO addUser(RuleForm ruleForm) {
        ResultVO resultVO = new ResultVO();
        User user = new User();
        user.setName(ruleForm.getUsername());
        String passwordEncode = this.passwordEncoder.encode(ruleForm.getPassword());  //  密码加密
        user.setPassword(passwordEncode);
        String userType = ruleForm.getUserType();
        if(Objects.equals(userType, "普通用户")){
            user.setIsAdmin(0);
        }else{
            user.setIsAdmin(1);
        }
        user.setIsDeleted(0);
        int result = this.userMapper.insert(user);
        resultVO = ResultVO.success("用户添加成功",user);
        return resultVO;
    }

    public ResultVO deleteUserByID(String id){
        ResultVO resultVO = new ResultVO();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        int result = this.userMapper.deleteByMap(map);
        if(result > 0){
            resultVO = ResultVO.success("用户删除成功");
        }else{
            resultVO = ResultVO.error("删除失败");
        }
        return resultVO;
    }

    @Override
    public ResultVO getAllUsers() {
        ResultVO resultVO = new ResultVO();
        List<User> userList = this.userMapper.selectList(null);
        resultVO = ResultVO.success("读取用户成功",userList);
        return resultVO;
    }

    @Override
    public ResultVO queryUser(String name, String userType) {
        ResultVO resultVO = new ResultVO();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        userType = Objects.equals(userType, "管理员") ? "1" : "0";
        queryWrapper.eq("name",name);
        queryWrapper.eq("is_admin",userType);
        List<User> userList = this.userMapper.selectList(queryWrapper);
        if(userList != null){
            resultVO = ResultVO.success("查找成功",userList);
        }else {
            resultVO = ResultVO.error("查无此人",null);
        }
        return resultVO;
    }

    @Override
    public ResultVO updateUser(RuleForm ruleForm) {
        ResultVO resultVO = new ResultVO();
        User user = new User();
        user.setId(ruleForm.getId());
        user.setName(ruleForm.getUsername());
        user.setPassword(ruleForm.getPassword());
        user.setIsDeleted(0);
        int isAdmin = Integer.parseInt(Objects.equals(ruleForm.getUserType(),"管理员") ? "1" : "0");
        user.setIsAdmin(isAdmin);
        int result = this.userMapper.updateById(user);
        if(result > 0){
            resultVO = ResultVO.success("更新成功");
        }else{
            resultVO = ResultVO.error("更新失败",null);
        }
        return resultVO;
    }
}




