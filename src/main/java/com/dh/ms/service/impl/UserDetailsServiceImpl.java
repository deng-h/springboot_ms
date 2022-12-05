package com.dh.ms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dh.ms.form.LoginUser;
import com.dh.ms.mapper.UserMapper;
import com.dh.ms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //查询数据库 根据用户名查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",username);
        User user = this.userMapper.selectOne(queryWrapper);

        //权限信息先放着
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");

        //返回用户信息 UserDetails对象
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("用户名不存在！");
        }
        return new LoginUser(user);  // 把数据封装成UserDetails返回
    }
}
