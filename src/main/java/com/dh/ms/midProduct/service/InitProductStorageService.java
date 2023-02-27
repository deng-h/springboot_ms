package com.dh.ms.midProduct.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.midProduct.bo.InitProdStorageBO;
import com.dh.ms.midProduct.entity.InitProductStorage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.midProduct.query.InitProductStorageQuery;
import org.springframework.web.bind.annotation.RequestBody;

/**
* @author Lenovo
* @description 针对表【init_product_storage(初产库存表)】的数据库操作Service
* @createDate 2023-02-27 09:17:15
*/
public interface InitProductStorageService extends IService<InitProductStorage> {
    IPage<InitProdStorageBO> listMidProdInitProdPages(InitProductStorageQuery query);

    boolean updateMidProdInitProd(InitProdStorageBO initProductStorageBO);
}
