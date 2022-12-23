package com.dh.ms.security.userdetails;

import com.dh.ms.pojo.bo.UserAuthInfo;
import com.dh.ms.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SysUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthInfo userAuthInfo = sysUserService.getUserAuthInfo(username);  // 获取数据库中的用户相关信息
        if (userAuthInfo == null) {
            throw new UsernameNotFoundException(username);
        }

        // 将系统用户的所有相关信息封装为UserDetails对象返回
        return new SysUserDetails(userAuthInfo);
    }
}
