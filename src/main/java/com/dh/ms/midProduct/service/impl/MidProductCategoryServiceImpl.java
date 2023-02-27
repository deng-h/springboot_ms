package com.dh.ms.midProduct.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.common.result.Result;
import com.dh.ms.midProduct.entity.MidProductCategory;
import com.dh.ms.midProduct.query.MidProdCategoryQuery;
import com.dh.ms.midProduct.service.MidProductCategoryService;
import com.dh.ms.mapper.midProduct.MidProductCategoryMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Lenovo
* @description 针对表【mid_product_category(产品分类表)】的数据库操作Service实现
* @createDate 2023-02-21 09:24:50
*/
@Service
public class MidProductCategoryServiceImpl extends ServiceImpl<MidProductCategoryMapper, MidProductCategory>
    implements MidProductCategoryService{


    /**
     * 获取产品分类分页列表
     */
    @Override
    public IPage<MidProductCategory> listMidProdCategoryPages(MidProdCategoryQuery query) {
        // 查询参数
        int pageNum = query.getPageNum();
        int pageSize = query.getPageSize();
        String categoryName = query.getCategoryName();

        // 查询数据
        Page<MidProductCategory> page = this.page(new Page<>(pageNum, pageSize),
                new LambdaQueryWrapper<MidProductCategory>()
                        .and(StrUtil.isNotBlank(categoryName),
                                wrapper -> wrapper.like(StrUtil.isNotBlank(categoryName),
                                        MidProductCategory::getName, categoryName)));
        return page;
    }

    @Override
    public boolean updateMidProdCategory(String id, String categoryName) {
        // 没考虑重名问题
        MidProductCategory midProductCategory = new MidProductCategory();
        midProductCategory.setId(id);
        midProductCategory.setName(categoryName);
        midProductCategory.setGmtModified(DateUtil.date());

        boolean b = this.updateById(midProductCategory);
        return b;
    }

    @Override
    public Result addMidProdCategory(String categoryName) {
        long count = this.count(new LambdaQueryWrapper<MidProductCategory>()
                .eq(MidProductCategory::getName, categoryName));
        if(count != 0){
            return Result.failed("分组名已存在!");
        }

        MidProductCategory midProductCategory = new MidProductCategory();
        midProductCategory.setName(categoryName);
        midProductCategory.setGmtCreate(DateUtil.date());
        midProductCategory.setGmtModified(DateUtil.date());
        boolean b = this.save(midProductCategory);
        return Result.judge(b);
    }

    @Override
    public boolean deleteMidProdCategory(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的数据为空");
        List<String> idList = Arrays.stream(ids.split(",")).collect(Collectors.toList());
        boolean b = this.removeByIds(idList);
        return b;
    }
}




