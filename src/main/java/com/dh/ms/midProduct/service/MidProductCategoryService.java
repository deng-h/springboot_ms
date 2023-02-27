package com.dh.ms.midProduct.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.common.result.Result;
import com.dh.ms.midProduct.entity.MidProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.midProduct.query.MidProdCategoryQuery;

/**
* @author Lenovo
* @description 针对表【mid_product_category(产品分类表)】的数据库操作Service
* @createDate 2023-02-21 09:24:50
*/
public interface MidProductCategoryService extends IService<MidProductCategory> {
    IPage<MidProductCategory> listMidProdCategoryPages(MidProdCategoryQuery query);

    boolean updateMidProdCategory(String id, String categoryName);

    Result addMidProdCategory(String categoryName);

    boolean deleteMidProdCategory(String ids);
}
