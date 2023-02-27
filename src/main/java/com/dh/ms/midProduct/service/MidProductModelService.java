package com.dh.ms.midProduct.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.common.result.Result;
import com.dh.ms.midProduct.bo.ModelAndCategoryNameBO;
import com.dh.ms.midProduct.entity.MidProductModel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.midProduct.query.MidProdModelQuery;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @author Lenovo
* @description 针对表【mid_product_model(产品型号表)】的数据库操作Service
* @createDate 2023-02-21 19:20:34
*/
public interface MidProductModelService extends IService<MidProductModel> {
    IPage<MidProductModel> listMidProdModelPages(MidProdModelQuery query);

    Result addMidProdModel(MidProductModel model);

    boolean updateMidProdModel(MidProductModel model);

    boolean deleteMidProdModel(String ids);

    /**
     * 通过产品型号得到产品型号名称和分类的名称
     * @param model  型号
     * @return 返回 ModelAndCategoryNameBO
     */
    ModelAndCategoryNameBO getModelAndCategoryNameByModel(String model);
}
