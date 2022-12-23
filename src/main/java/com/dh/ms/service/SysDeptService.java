package com.dh.ms.service;

import com.dh.ms.common.model.Option;
import com.dh.ms.pojo.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.pojo.form.DeptForm;
import com.dh.ms.pojo.query.DeptQuery;
import com.dh.ms.pojo.vo.dept.DeptVO;

import java.util.List;

/**
* @author dell
* @description 针对表【sys_dept(部门表)】的数据库操作Service
* @createDate 2022-12-19 19:03:19
*/
public interface SysDeptService extends IService<SysDept> {

    List<DeptVO> listDepartments(DeptQuery queryParams);

    List<Option> listDeptOptions();

    DeptForm getDeptForm(Long deptId);

    Long saveDept(DeptForm formData);

    Long updateDept(Long deptId, DeptForm formData);

    boolean deleteByIds(String ids);
}
