package com.dh.ms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.common.constant.SystemConstants;
import com.dh.ms.common.enums.StatusEnum;
import com.dh.ms.common.model.Option;
import com.dh.ms.converter.DeptConverter;
import com.dh.ms.pojo.entity.SysDept;
import com.dh.ms.pojo.form.DeptForm;
import com.dh.ms.pojo.query.DeptQuery;
import com.dh.ms.pojo.vo.dept.DeptVO;
import com.dh.ms.service.SysDeptService;
import com.dh.ms.mapper.system.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
* @author dell
* @description 针对表【sys_dept(部门表)】的数据库操作Service实现
* @createDate 2022-12-19 19:03:19
*/
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService{

    @Autowired
    private DeptConverter deptConverter;

    /**
     * 部门列表
     */
    @Override
    public List<DeptVO> listDepartments(DeptQuery queryParams) {
        // 查询参数
        String keywords = queryParams.getKeywords();
        Integer status = queryParams.getStatus();

        // 查询数据
        List<SysDept> deptList = this.list(
                new LambdaQueryWrapper<SysDept>()
                        .like(StrUtil.isNotBlank(keywords), SysDept::getName, keywords)
                        .eq(Validator.isNotNull(status), SysDept::getStatus, status)
                        .orderByAsc(SysDept::getSort)
        );

        List<DeptVO> list = new ArrayList<>();

        if (CollectionUtil.isNotEmpty(deptList)) {

            Set<Long> cacheDeptIds = deptList.stream()
                    .map(SysDept::getId)
                    .collect(Collectors.toSet());


            for (SysDept dept : deptList) {
                Long parentId = dept.getParentId();
                // 不在缓存ID列表的parentId是顶级节点ID，以此作为递归开始
                if (cacheDeptIds.contains(parentId) == false) {
                    list.addAll(recurDepartments(parentId, deptList));
                    cacheDeptIds.add(parentId); // 避免重复递归
                }
            }
        }

        //  列表为空说明所有的节点都是独立的
        if (list.isEmpty()) {
            return deptList.stream().map(item -> {
                        DeptVO deptVO = new DeptVO();
                        BeanUtil.copyProperties(item, deptVO);
                        return deptVO;
                    })
                    .collect(Collectors.toList());
        }

        return list;
    }

    /**
     * 递归生成部门层级列表
     *
     * @param parentId
     * @param deptList
     * @return
     */
    public List<DeptVO> recurDepartments(Long parentId, List<SysDept> deptList) {
        List<DeptVO> list = deptList.stream()
                .filter(dept -> dept.getParentId().equals(parentId))
                .map(dept -> {
                    DeptVO deptVO = deptConverter.entity2Vo(dept);
                    List<DeptVO> children = recurDepartments(dept.getId(), deptList);
                    deptVO.setChildren(children);
                    return deptVO;
                }).collect(Collectors.toList());
        return list;
    }

    /**
     * 部门下拉选项
     *
     * @return
     */
    @Override
    public List<Option> listDeptOptions() {
        List<SysDept> deptList = this.list(new LambdaQueryWrapper<SysDept>()
                .eq(SysDept::getStatus, StatusEnum.ENABLE.getValue())
                .select(SysDept::getId, SysDept::getParentId, SysDept::getName)
                .orderByAsc(SysDept::getSort)
        );
        List<Option> options = recurDeptTreeOptions(SystemConstants.ROOT_NODE_ID, deptList);
        return options;
    }

    /**
     * 递归生成部门表格层级列表
     *
     * @param parentId
     * @param deptList
     * @return
     */
    public static List<Option> recurDeptTreeOptions(long parentId, List<SysDept> deptList) {
        if (CollectionUtil.isEmpty(deptList)) {
            return Collections.EMPTY_LIST;
        }

        List<Option> list = deptList.stream()
                .filter(dept -> dept.getParentId().equals(parentId))
                .map(dept -> {
                    Option option = new Option(dept.getId(), dept.getName());
                    List<Option> children = recurDeptTreeOptions(dept.getId(), deptList);
                    if (CollectionUtil.isNotEmpty(children)) {
                        option.setChildren(children);
                    }
                    return option;
                })
                .collect(Collectors.toList());

        return list;
    }

    /**
     * 获取部门详情
     *
     * @param deptId
     * @return
     */
    @Override
    public DeptForm getDeptForm(Long deptId) {

        SysDept entity = this.getOne(new LambdaQueryWrapper<SysDept>()
                .eq(SysDept::getId, deptId)
                .select(
                        SysDept::getId,
                        SysDept::getName,
                        SysDept::getParentId,
                        SysDept::getStatus,
                        SysDept::getSort
                ));

        DeptForm deptForm = deptConverter.entity2Form(entity);
        return deptForm;
    }

    @Override
    public Long saveDept(DeptForm formData) {
        SysDept entity = deptConverter.form2Entity(formData);
        // 部门路径
        String treePath = generateDeptTreePath(formData.getParentId());
        entity.setTreePath(treePath);
        // 保存部门并返回部门ID
        this.save(entity);
        return entity.getId();
    }

    /**
     * 部门路径生成
     *
     * @param parentId
     * @return
     */
    private String generateDeptTreePath(Long parentId) {
        String treePath = null;
        if (SystemConstants.ROOT_NODE_ID.equals(parentId)) {
            treePath = parentId + "";
        } else {
            SysDept parent = this.getById(parentId);
            if (parent != null) {
                treePath = parent.getTreePath() + "," + parent.getId();
            }
        }
        return treePath;
    }

    /**
     * 删除部门
     *
     * @param ids 部门ID，多个以英文逗号,拼接字符串
     * @return
     */
    @Override
    public boolean deleteByIds(String ids) {
        // 删除部门及子部门
        Optional.ofNullable(Arrays.stream(ids.split(",")))
                .ifPresent(deptIds -> deptIds.forEach(deptId ->
                        this.remove(new LambdaQueryWrapper<SysDept>()
                                .eq(SysDept::getId, deptId)
                                .or()
                                .apply("concat (',',tree_path,',') like concat('%,',{0},',%')", deptId))
                ));
        return true;
    }

    @Override
    public Long updateDept(Long deptId, DeptForm formData) {
        // form->entity
        SysDept entity = deptConverter.form2Entity(formData);
        entity.setId(deptId);
        // 部门路径
        String treePath = generateDeptTreePath(formData.getParentId());
        entity.setTreePath(treePath);
        // 保存部门并返回部门ID
        this.updateById(entity);
        return entity.getId();
    }
}




