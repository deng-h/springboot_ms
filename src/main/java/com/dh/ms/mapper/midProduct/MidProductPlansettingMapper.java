package com.dh.ms.mapper.midProduct;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dh.ms.midProduct.bo.MidPlanSettingBO;
import com.dh.ms.midProduct.entity.MidProductPlansetting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Lenovo
* @description 针对表【mid_product_plansetting(设备生产计划设定表)】的数据库操作Mapper
* @createDate 2023-02-22 15:33:47
* @Entity com.dh.ms.midProduct.entity.MidProductPlansetting
*/
@Repository
public interface MidProductPlansettingMapper extends BaseMapper<MidProductPlansetting> {
    IPage<MidPlanSettingBO> getMidPlanSettingBO(Page<?> page, String deviceAddr);
}




