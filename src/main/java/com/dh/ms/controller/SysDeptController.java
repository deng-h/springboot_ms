package com.dh.ms.controller;


import com.dh.ms.common.model.Option;
import com.dh.ms.common.result.Result;
import com.dh.ms.pojo.form.DeptForm;
import com.dh.ms.pojo.query.DeptQuery;
import com.dh.ms.pojo.vo.dept.DeptVO;
import com.dh.ms.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "部门接口")
@RestController
@RequestMapping("/dept")
public class SysDeptController {

    @Autowired
    private SysDeptService deptService;

    @ApiOperation(value = "获取部门列表")
    @GetMapping
    public Result<List<DeptVO>> listDepartments(DeptQuery queryParams) {
        List<DeptVO> list = deptService.listDepartments(queryParams);
        return Result.success(list);
    }

    @ApiOperation(value = "获取部门下拉选项")
    @GetMapping("/options")
    public Result<List<Option>> listDeptOptions() {
        List<Option> list = deptService.listDeptOptions();
        return Result.success(list);
    }

    @ApiOperation(value = "获取部门详情")
    @GetMapping("/{deptId}/form")
    public Result<DeptForm> getDeptForm(@ApiParam("部门ID") @PathVariable Long deptId) {
        DeptForm deptForm = deptService.getDeptForm(deptId);
        return Result.success(deptForm);
    }

    @ApiOperation(value = "新增部门")
    @PostMapping
    public Result saveDept(@Valid @RequestBody DeptForm formData) {
        Long id = deptService.saveDept(formData);
        return Result.success(id);
    }

    @ApiOperation(value = "修改部门")
    @PutMapping(value = "/{deptId}")
    public Result updateDept(@PathVariable Long deptId,@Valid @RequestBody DeptForm formData) {
        deptId = deptService.updateDept(deptId, formData);
        return Result.success(deptId);
    }

    @ApiOperation(value = "删除部门")
    @DeleteMapping("/{ids}")
    public Result deleteDepartments(
            @ApiParam("部门ID，多个以英文逗号(,)分割") @PathVariable("ids") String ids
    ) {
        boolean result = deptService.deleteByIds(ids);
        return Result.judge(result);
    }
}
