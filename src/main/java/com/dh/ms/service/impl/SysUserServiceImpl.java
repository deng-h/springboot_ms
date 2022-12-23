package com.dh.ms.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.common.constant.SystemConstants;
import com.dh.ms.converter.UserConverter;
import com.dh.ms.pojo.bo.UserAuthInfo;
import com.dh.ms.pojo.bo.UserBO;
import com.dh.ms.pojo.bo.UserFormBO;
import com.dh.ms.pojo.entity.SysUser;
import com.dh.ms.pojo.form.UserForm;
import com.dh.ms.pojo.query.UserPageQuery;
import com.dh.ms.pojo.vo.user.UserLoginVO;
import com.dh.ms.pojo.vo.user.UserVO;
import com.dh.ms.service.SysMenuService;
import com.dh.ms.service.SysRoleService;
import com.dh.ms.service.SysUserRoleService;
import com.dh.ms.service.SysUserService;
import com.dh.ms.mapper.SysUserMapper;
import com.dh.ms.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysUserRoleService userRoleService;

    /**
     * 获取登录用户信息
     */
    @Override
    public UserLoginVO getUserLoginInfo() {
        // 登录用户entity
        SysUser user = this.getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, Objects.requireNonNull(SecurityUtils.getUser()).getUsername())
                .select(SysUser::getId, SysUser::getNickname, SysUser::getAvatar)
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
        if(userAuthInfo != null){
            Set<String> roles = userAuthInfo.getRoles();
            if(CollectionUtil.isNotEmpty(roles)){
                Set<String> perms = this.menuService.listRolePerms(roles);  // 根据角色查询权限信息
                userAuthInfo.setPerms(perms);
            }
        }
        return userAuthInfo;
    }

    /**
     * 获取用户分页列表
     */
    @Override
    public IPage<UserVO> listUserPages(UserPageQuery queryParams) {
        int pageNum = queryParams.getPageNum();
        int pageSize = queryParams.getPageSize();
        Page<UserBO> page = new Page<>(pageNum, pageSize);
        // 查询数据
        Page<UserBO> userPoPage = this.baseMapper.listUserPages(page, queryParams);
        // 实体转换
        Page<UserVO> userVoPage = userConverter.po2Vo(userPoPage);
        return userVoPage;
    }

    /**
     * 获取用户详情
     *
     * @param userId
     * @return
     */
    @Override
    public UserForm getUserFormData(Long userId) {
        UserFormBO userFormBO = this.baseMapper.getUserDetail(userId);
        // 实体转换po->form
        UserForm userForm = userConverter.po2Form(userFormBO);
        return userForm;
    }

    /**
     * 新增用户
     *
     * @param userForm 用户表单对象
     * @return
     */
    @Override
    public boolean saveUser(UserForm userForm) {

        String username = userForm.getUsername();

        long count = this.count(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        Assert.isTrue(count == 0, "用户名已存在");

        // 实体转换 form->entity
        SysUser entity = userConverter.form2Entity(userForm);

        // 设置默认加密密码
        String defaultEncryptPwd = passwordEncoder.encode(SystemConstants.DEFAULT_USER_PASSWORD);
        entity.setPassword(defaultEncryptPwd);

        // 新增用户
        boolean result = this.save(entity);

        if (result) {
            // 保存用户角色
            userRoleService.saveUserRoles(entity.getId(), userForm.getRoleIds());
        }
        return result;
    }

    /**
     * 更新用户
     *
     * @param userId   用户ID
     * @param userForm 用户表单对象
     * @return
     */
    @Override
    @Transactional
    public boolean updateUser(Long userId, UserForm userForm) {

        String username = userForm.getUsername();

        long count = this.count(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, username)
                .ne(SysUser::getId, userId)
        );
        Assert.isTrue(count == 0, "用户名已存在");

        // form -> entity
        SysUser entity = userConverter.form2Entity(userForm);

        // 修改用户
        boolean result = this.updateById(entity);

        if (result) {
            // 保存用户角色
            userRoleService.saveUserRoles(entity.getId(), userForm.getRoleIds());
        }
        return result;
    }

    /**
     * 修改用户密码
     *
     * @param userId   用户ID
     * @param password 用户密码
     * @return
     */
    @Override
    public boolean updatePassword(Long userId, String password) {
        String encryptedPassword = passwordEncoder.encode(password);
        boolean result = this.update(new LambdaUpdateWrapper<SysUser>()
                .eq(SysUser::getId, userId)
                .set(SysUser::getPassword, encryptedPassword)
        );

        return result;
    }

    /**
     * 删除用户
     *
     * @param idsStr 用户ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deleteUsers(String idsStr) {
        Assert.isTrue(StrUtil.isNotBlank(idsStr), "删除的用户数据为空");
        // 逻辑删除
        List<Long> ids = Arrays.asList(idsStr.split(",")).stream()
                .map(idStr -> Long.parseLong(idStr)).collect(Collectors.toList());
        boolean result = this.removeByIds(ids);
        return result;

    }

}




