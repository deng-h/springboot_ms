package com.dh.ms.pojo.query;


import com.dh.ms.common.base.BasePageQuery;
import lombok.*;

/**
 * 用户分页查询对象
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserPageQuery extends BasePageQuery {

    private String keywords;

    private Integer status;

    private Long deptId;

}
