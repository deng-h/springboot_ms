package com.dh.ms.security.userdetails;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.dh.ms.pojo.bo.UserAuthInfo;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
public class SysUserDetails implements UserDetails {
    private Long userId;

    private String username;

    private String password;

    private Boolean enabled;

    private Collection<SimpleGrantedAuthority> authorities;

    private String authorityStr;

    private Set<String> perms;

    public SysUserDetails() {

    }

    public SysUserDetails(UserAuthInfo user) {
        this.userId = user.getUserId();
        Set<String> roles = user.getRoles();
        Set<SimpleGrantedAuthority> authorities;
        // 把字符串形式表示的角色信息转为SimpleGrantedAuthority类型的角色信息
        if (CollectionUtil.isNotEmpty(roles)) {
            authorities = roles.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role)) // 标识角色
                    .collect(Collectors.toSet());
        } else {
            authorities = Collections.EMPTY_SET;
        }
        this.authorities = authorities;
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = ObjectUtil.equal(user.getStatus(), 1);
        this.perms = user.getPerms();
    }

    public Long getUserId() {
        return this.userId;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
