package com.dh.ms.midProduct.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.midProduct.bo.MidPlanSettingBO;
import com.dh.ms.midProduct.entity.MidProductPlansetting;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.midProduct.query.MidProdPlanQuery;

/**
* @author Lenovo
* @description 针对表【mid_product_plansetting(设备生产计划设定表)】的数据库操作Service
* @createDate 2023-02-22 15:33:48
*/
public interface MidProductPlansettingService extends IService<MidProductPlansetting> {
    IPage<MidPlanSettingBO> listMidProdPlanPages(MidProdPlanQuery query);
}
