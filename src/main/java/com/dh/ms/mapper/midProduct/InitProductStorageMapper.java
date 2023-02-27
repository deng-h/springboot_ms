package com.dh.ms.mapper.midProduct;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dh.ms.midProduct.bo.InitProdStorageBO;
import com.dh.ms.midProduct.entity.InitProductStorage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Lenovo
* @description 针对表【init_product_storage(初产库存表)】的数据库操作Mapper
* @createDate 2023-02-27 09:17:15
* @Entity com.dh.ms.midProduct.entity.InitProductStorage
*/
@Repository
public interface InitProductStorageMapper extends BaseMapper<InitProductStorage> {
    IPage<InitProdStorageBO> listMidProdInitProdPages(Page<?> page, String model);

    InitProdStorageBO getMidProdInitProdDetailById(String id);
}




