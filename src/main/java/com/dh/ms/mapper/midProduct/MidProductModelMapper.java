package com.dh.ms.mapper.midProduct;

import com.dh.ms.midProduct.bo.ModelAndCategoryNameBO;
import com.dh.ms.midProduct.entity.MidProductModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Lenovo
* @description 针对表【mid_product_model(产品型号表)】的数据库操作Mapper
* @createDate 2023-02-21 19:20:34
* @Entity com.dh.ms.midProduct.entity.MidProductModel
*/
@Repository
public interface MidProductModelMapper extends BaseMapper<MidProductModel> {

    /**
     * 返回最新的一条排单数据
     * @param  model 产品型号
     * @return ModelAndCategoryNameBO 数据对象
     */
    ModelAndCategoryNameBO getModelAndCategoryNameByModel(String model);
}




