package com.dh.ms.midProduct.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.midProduct.bo.MidPlanSettingBO;
import com.dh.ms.midProduct.entity.MidProductPlansetting;
import com.dh.ms.midProduct.query.MidProdPlanQuery;
import com.dh.ms.midProduct.service.MidProductPlansettingService;
import com.dh.ms.mapper.midProduct.MidProductPlansettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Lenovo
* @description 针对表【mid_product_plansetting(设备生产计划设定表)】的数据库操作Service实现
* @createDate 2023-02-22 15:33:47
*/
@Service
public class MidProductPlansettingServiceImpl extends ServiceImpl<MidProductPlansettingMapper, MidProductPlansetting>
    implements MidProductPlansettingService{

    @Autowired
    private MidProductPlansettingMapper midProductPlansettingMapper;

    @Override
    public IPage<MidPlanSettingBO> listMidProdPlanPages(MidProdPlanQuery query) {
        // 查询参数
        int pageNum = query.getPageNum();
        int pageSize = query.getPageSize();
        String deviceAddr = query.getDeviceAddr();
        Page<MidPlanSettingBO> page = new Page<>(pageNum, pageSize);
        IPage<MidPlanSettingBO> midPlanSettingBOIPage = midProductPlansettingMapper.getMidPlanSettingBO(page, deviceAddr);
        return midPlanSettingBOIPage;
    }
}




