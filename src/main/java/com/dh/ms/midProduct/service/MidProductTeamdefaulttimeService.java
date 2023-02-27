package com.dh.ms.midProduct.service;

import com.dh.ms.common.result.Result;
import com.dh.ms.midProduct.entity.MidProductTeamdefaulttime;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Lenovo
* @description 针对表【mid_product_teamdefaulttime(默认班组时间设定表)】的数据库操作Service
* @createDate 2023-02-22 10:39:50
*/
public interface MidProductTeamdefaulttimeService extends IService<MidProductTeamdefaulttime> {
    Result getDataByTeamType(String teamType);

    boolean updateTeamDefaultTime(MidProductTeamdefaulttime teamDefaultTime);
}
