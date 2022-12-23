package com.dh.ms.pojo.query;

import com.dh.ms.common.base.BasePageQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 踏板参数分页查询对象
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedalPageQuery extends BasePageQuery {
    private String keywords;
}
