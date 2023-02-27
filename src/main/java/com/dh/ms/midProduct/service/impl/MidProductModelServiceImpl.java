package com.dh.ms.midProduct.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.common.result.Result;
import com.dh.ms.midProduct.bo.ModelAndCategoryNameBO;
import com.dh.ms.midProduct.entity.MidProductModel;
import com.dh.ms.midProduct.query.MidProdModelQuery;
import com.dh.ms.midProduct.service.MidProductModelService;
import com.dh.ms.mapper.midProduct.MidProductModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Lenovo
* @description 针对表【mid_product_model(产品型号表)】的数据库操作Service实现
* @createDate 2023-02-21 19:20:34
*/
@Service
public class MidProductModelServiceImpl extends ServiceImpl<MidProductModelMapper, MidProductModel>
    implements MidProductModelService{

    @Autowired
    private MidProductModelMapper midProductModelMapper;

    @Override
    public IPage<MidProductModel> listMidProdModelPages(MidProdModelQuery query) {
        // 查询参数
        int pageNum = query.getPageNum();
        int pageSize = query.getPageSize();
        String model = query.getModel();
        String category = query.getCategory();

        Page<MidProductModel> page = this.page(new Page<>(pageNum, pageSize),
                new LambdaQueryWrapper<MidProductModel>()
                        .and(StrUtil.isNotBlank(model), wrapper -> wrapper.like(StrUtil.isNotBlank(model), MidProductModel::getName, model))
                        .and(StrUtil.isNotBlank(category), wrapper -> wrapper.like(StrUtil.isNotBlank(category), MidProductModel::getCategoryId, category)));

        return page;
    }

    @Override
    public Result addMidProdModel(MidProductModel model) {
        // 没考虑重名的情况
        MidProductModel midProductModel = new MidProductModel();
        midProductModel.setModel(model.getModel());
        midProductModel.setName(model.getName());
        midProductModel.setCategoryId(model.getCategoryId());
        midProductModel.setGmtCreate(DateUtil.date());
        midProductModel.setGmtModified(DateUtil.date());
        boolean b = this.save(midProductModel);
        return Result.judge(b);
    }

    @Override
    public boolean updateMidProdModel(MidProductModel model) {
        MidProductModel midProductModel = new MidProductModel();
        midProductModel.setId(model.getId());
        midProductModel.setModel(model.getModel());
        midProductModel.setName(model.getName());
        midProductModel.setCategoryId(model.getCategoryId());
        midProductModel.setGmtModified(DateUtil.date());
        boolean b = this.updateById(midProductModel);
        return b;
    }

    @Override
    public boolean deleteMidProdModel(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的数据为空");
        List<String> idList = Arrays.stream(ids.split(",")).collect(Collectors.toList());
        boolean b = this.removeByIds(idList);
        return b;
    }

    @Override
    public ModelAndCategoryNameBO getModelAndCategoryNameByModel(String model) {
        ModelAndCategoryNameBO res = midProductModelMapper.getModelAndCategoryNameByModel(model);
        return res;
    }
}




