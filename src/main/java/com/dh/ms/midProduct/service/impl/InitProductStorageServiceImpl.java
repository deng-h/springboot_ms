package com.dh.ms.midProduct.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.mapper.midProduct.MidProductModelMapper;
import com.dh.ms.midProduct.bo.InitProdStorageBO;
import com.dh.ms.midProduct.entity.InitProductStorage;
import com.dh.ms.midProduct.entity.MidProductModel;
import com.dh.ms.midProduct.query.InitProductStorageQuery;
import com.dh.ms.midProduct.service.InitProductStorageService;
import com.dh.ms.mapper.midProduct.InitProductStorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Lenovo
* @description 针对表【init_product_storage(初产库存表)】的数据库操作Service实现
* @createDate 2023-02-27 09:17:15
*/
@Service
public class InitProductStorageServiceImpl extends ServiceImpl<InitProductStorageMapper, InitProductStorage>
    implements InitProductStorageService{

    @Autowired
    private InitProductStorageMapper initProductStorageMapper;

    @Autowired
    private MidProductModelMapper midProductModelMapper;

    @Override
    public IPage<InitProdStorageBO> listMidProdInitProdPages(InitProductStorageQuery query) {
        // 查询参数
        int pageNum = query.getPageNum();
        int pageSize = query.getPageSize();
        String model = query.getModel();

        // 查询数据
        Page<InitProdStorageBO> page = new Page<>(pageNum, pageSize);
        IPage<InitProdStorageBO> initProductStorageIPage = initProductStorageMapper.listMidProdInitProdPages(page, model);
        return initProductStorageIPage;
    }

    @Override
    public boolean updateMidProdInitProd(InitProdStorageBO initProductStorageBO) {
        InitProductStorage storage = new InitProductStorage();
        storage.setId(initProductStorageBO.getId());
        String model = initProductStorageBO.getModel();
        // 根据model名查model的ID
        MidProductModel midProductModel = midProductModelMapper.selectOne(new LambdaQueryWrapper<MidProductModel>()
                .eq(MidProductModel::getModel, model));
        storage.setProductId(midProductModel.getId());
        storage.setStocks(initProductStorageBO.getStocks());
        storage.setAdminName(initProductStorageBO.getAdminName());
        storage.setGmtModified(DateUtil.date());
        boolean b = this.updateById(storage);
        return b;
    }
}




