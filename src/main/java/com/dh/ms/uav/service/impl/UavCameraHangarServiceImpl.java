package com.dh.ms.uav.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.common.result.Result;
import com.dh.ms.uav.entity.UavCameraHangar;
import com.dh.ms.uav.query.CameraHangarQuery;
import com.dh.ms.uav.service.UavCameraHangarService;
import com.dh.ms.mapper.uav.UavCameraHangarMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
* @author Lenovo
* @description 针对表【uav_camera_hangar(UavCameraHangar)】的数据库操作Service实现
* @createDate 2023-01-28 20:10:41
*/
@Service
public class UavCameraHangarServiceImpl extends ServiceImpl<UavCameraHangarMapper, UavCameraHangar>
    implements UavCameraHangarService{

    @Override
    public IPage<UavCameraHangar> listCameraHangarPages(CameraHangarQuery query) {
        // 查询参数
        int pageNum = query.getPageNum();
        int pageSize = query.getPageSize();
        String keywords = query.getKeywords();

        // 查询数据
        Page<UavCameraHangar> page = this.page(new Page<>(pageNum, pageSize),
                new LambdaQueryWrapper<UavCameraHangar>()
                        .and(StrUtil.isNotBlank(keywords),
                                wrapper -> wrapper.like(StrUtil.isNotBlank(keywords),
                                        UavCameraHangar::getHangarCategory, keywords)));
        return page;
    }

    @Override
    public boolean deleteCameraHangars(String idStr) {
        Assert.isTrue(StrUtil.isNotBlank(idStr), "删除的数据为空");
        List<String> idList = Arrays.stream(idStr.split(",")).collect(Collectors.toList());
        boolean result = this.removeByIds(idList);
        return result;
    }

    @Override
    public Result addCameraHangar(String hangarCategory) {
        long count = this.count(new LambdaQueryWrapper<UavCameraHangar>()
                .eq(UavCameraHangar::getHangarCategory, hangarCategory));
        if(count != 0){
            return Result.failed("分组名已存在!");
        }

        UavCameraHangar uavCameraHangar = new UavCameraHangar();
        uavCameraHangar.setHangarCategory(hangarCategory);
        uavCameraHangar.setGmtCreate(DateUtil.date());

        boolean b = this.save(uavCameraHangar);
        return Result.judge(b);
    }

    @Override
    public boolean updateCameraHangar(String id, String hangarCategory) {
        // 没考虑重名问题
        UavCameraHangar uavCameraHangar = new UavCameraHangar();
        uavCameraHangar.setId(id);
        uavCameraHangar.setHangarCategory(hangarCategory);
        uavCameraHangar.setGmtModified(DateUtil.date());

        boolean b = this.updateById(uavCameraHangar);
        return b;
    }

    @Override
    public List<UavCameraHangar> getHangarCategory() {
        List<UavCameraHangar> uavCameraHangarList = baseMapper.selectList(null);
        return uavCameraHangarList;
    }
}




