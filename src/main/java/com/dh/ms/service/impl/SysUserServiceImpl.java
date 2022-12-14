package com.dh.ms.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.converter.UserConverter;
import com.dh.ms.mapper.SysMenuMapper;
import com.dh.ms.mapper.SysRoleMapper;
import com.dh.ms.pojo.bo.UserAuthInfo;
import com.dh.ms.pojo.entity.SysRole;
import com.dh.ms.pojo.entity.SysUser;
import com.dh.ms.pojo.vo.user.UserLoginVO;
import com.dh.ms.service.SysMenuService;
import com.dh.ms.service.SysRoleService;
import com.dh.ms.service.SysUserService;
import com.dh.ms.mapper.SysUserMapper;
import com.dh.ms.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
* @author dell
* @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
* @createDate 2022-12-12 13:56:01
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService{

    @Resource
    private UserConverter userConverter;

    @Autowired
    private SysMenuService menuService;

    @Autowired
    private SysRoleService roleService;

    /**
     * 获取登录用户信息
     */
    @Override
    public UserLoginVO getUserLoginInfo() {
        // 登录用户entity
        SysUser user = this.getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, Objects.requireNonNull(SecurityUtils.getUser()).getUsername())
                .select(
                        SysUser::getId,
                        SysUser::getNickname,
                        SysUser::getAvatar
                )
        );
        // entity->VO
        UserLoginVO userLoginVO = userConverter.entity2LoginUser(user);

        // 用户角色集合
        Set<String> roles = SecurityUtils.getRoles();
        userLoginVO.setRoles(roles);

        // 用户权限集合
        Set<String> perms = SecurityUtils.getPerms();
        userLoginVO.setPerms(perms);

        return userLoginVO;
    }

    /**
     * 根据用户名获取认证信息
     */
    @Override
    public UserAuthInfo getUserAuthInfo(String username) {
        UserAuthInfo userAuthInfo = this.baseMapper.getUserAuthInfo(username);
        Long roleId = userAuthInfo.getRoleId();
        // 数据库里没有做到连表查询 所以roles的数据单独查询然后赋值给userAuthInfo
        Set<String> roles = this.roleService.selectCodeById(roleId);
        if(userAuthInfo != null){
            // 没有从userAuthInfo直接获取角色 因为相关的数据库查询代码(SysUserMapper.xml)还没搞懂
//            Set<String> roles = userAuthInfo.getRoles();
            if(CollectionUtil.isNotEmpty(roles)){
                userAuthInfo.setRoles(roles);
                Set<String> perms= this.menuService.listRolePerms(roles);  // 根据角色查询权限信息
                userAuthInfo.setPerms(perms);
            }
        }
        return userAuthInfo;
    }
}




