package com.dh.ms.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 部门查询对象
 */
@ApiModel("部门分页查询对象")
@Data
public class DeptQuery {

    @ApiModelProperty("关键字(部门名称)")
    private String keywords;

    @ApiModelProperty("状态(1->正常；0->禁用)")
    private Integer status;

}

