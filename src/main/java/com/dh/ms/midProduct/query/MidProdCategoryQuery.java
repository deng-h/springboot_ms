package com.dh.ms.midProduct.query;


import com.dh.ms.common.base.BasePageQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 分页查询对象
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MidProdCategoryQuery extends BasePageQuery {
    private String categoryName;
}
