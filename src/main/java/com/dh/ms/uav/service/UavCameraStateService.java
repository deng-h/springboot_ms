package com.dh.ms.uav.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dh.ms.common.result.Result;
import com.dh.ms.uav.entity.UavCameraState;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.uav.form.CameraStateForm;
import com.dh.ms.uav.query.CameraStateQuery;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
* @author Lenovo
* @description 针对表【uav_camera_state(uav_camera_state)】的数据库操作Service
* @createDate 2023-01-31 09:10:13
*/
public interface UavCameraStateService extends IService<UavCameraState> {
    IPage<UavCameraState> listCameraStatePages(CameraStateQuery query);

    boolean deleteCameraState(String idStr);

    boolean addCameraState(CameraStateForm cameraStateForm);

    boolean updateCameraState(CameraStateForm cameraStateForm);
}
