package com.dh.ms.uav.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.common.base.BasePageQuery;
import com.dh.ms.common.result.Result;
import com.dh.ms.uav.entity.UavCameraHangar;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.uav.query.CameraHangarQuery;
import com.dh.ms.uav.vo.CameraHangarPageVO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
* @author Lenovo
* @description 针对表【uav_camera_hangar(UavCameraHangar)】的数据库操作Service
* @createDate 2023-01-28 20:10:41
*/
public interface UavCameraHangarService extends IService<UavCameraHangar> {
    IPage<UavCameraHangar> listCameraHangarPages(CameraHangarQuery query);

    boolean deleteCameraHangars(String idStr);

    Result addCameraHangar(String hangarCategory);

    boolean updateCameraHangar(String id, String hangarCategory);

    List<UavCameraHangar> getHangarCategory();
}
