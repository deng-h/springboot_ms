package com.dh.ms.uav.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.mapper.uav.UavCameraHangarMapper;
import com.dh.ms.uav.entity.UavCameraHangar;
import com.dh.ms.uav.entity.UavCameraState;
import com.dh.ms.uav.form.CameraStateForm;
import com.dh.ms.uav.query.CameraStateQuery;
import com.dh.ms.uav.service.UavCameraStateService;
import com.dh.ms.mapper.uav.UavCameraStateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Lenovo
* @description 针对表【uav_camera_state(uav_camera_state)】的数据库操作Service实现
* @createDate 2023-01-31 09:10:13
*/
@Service
public class UavCameraStateServiceImpl extends ServiceImpl<UavCameraStateMapper, UavCameraState>
    implements UavCameraStateService{

    @Autowired
    private UavCameraHangarMapper uavCameraHangarMapper;

    @Override
    public IPage<UavCameraState> listCameraStatePages(CameraStateQuery query) {
        // 查询参数
        int pageNum = query.getPageNum();
        int pageSize = query.getPageSize();
        String keywords = query.getKeywords();

        // 查询CameraId数据
        Page<UavCameraState> page = this.page(new Page<>(pageNum, pageSize),
                new LambdaQueryWrapper<UavCameraState>()
                        .and(StrUtil.isNotBlank(keywords),
                                wrapper -> wrapper.like(StrUtil.isNotBlank(keywords),
                                        UavCameraState::getCameraId, keywords)));
        return page;
    }

    @Override
    public boolean deleteCameraState(String idStr) {
        Assert.isTrue(StrUtil.isNotBlank(idStr), "删除的数据为空");
        List<String> idList = Arrays.stream(idStr.split(",")).collect(Collectors.toList());
        boolean result = this.removeByIds(idList);  // 逻辑删除
        return result;
    }

    @Override
    public boolean addCameraState(CameraStateForm cameraStateForm) {
        UavCameraState uavCameraState = new UavCameraState();
        String categoryId = cameraStateForm.getCategoryId();
        uavCameraState.setCategoryId(cameraStateForm.getCategoryId());
        // 在uav_camera_hangar表中 根据categoryId找到categoryName
        UavCameraHangar uavCameraHangar = uavCameraHangarMapper.selectById(categoryId);
        uavCameraState.setCategoryName(uavCameraHangar.getHangarCategory());
        uavCameraState.setCameraId(cameraStateForm.getCameraId());
        uavCameraState.setCameraUrl(cameraStateForm.getCameraUrl());
        uavCameraState.setCameraAccessToken("token");
        uavCameraState.setGmtCreate(DateUtil.date());

        boolean b = this.save(uavCameraState);
        return b;
    }

    @Override
    public boolean updateCameraState(CameraStateForm cameraStateForm) {
        UavCameraState uavCameraState = new UavCameraState();

        uavCameraState.setId(cameraStateForm.getId());
        uavCameraState.setCategoryId(cameraStateForm.getCategoryId());
        uavCameraState.setCameraUrl(cameraStateForm.getCameraUrl());
        uavCameraState.setCameraId(cameraStateForm.getCameraId());
        uavCameraState.setGmtModified(DateUtil.date());

        boolean b = this.updateById(uavCameraState);
        return b;
    }
}




