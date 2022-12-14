package com.dh.ms.security.userdetails;

import cn.hutool.core.collection.CollectionUtil;
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
        UserAuthInfo userAuthInfo = this.sysUserService.getUserAuthInfo(username);
        Set<String> perms = userAuthInfo.getPerms();
        if(CollectionUtil.isEmpty(perms)){
            System.out.println("perms is empty!");
        }
        if (userAuthInfo == null) {
            throw new UsernameNotFoundException(username);
        }
        return new SysUserDetails(userAuthInfo);
    }
}
