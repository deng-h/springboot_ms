package com.dh.ms.service;

import com.dh.ms.pojo.PedalFixedParam;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dh.ms.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @author dell
* @description 针对表【pedal_fixed_param(踏板固定参数表)】的数据库操作Service
* @createDate 2022-11-05 10:39:51
*/
public interface PedalFixedParamService extends IService<PedalFixedParam> {
    public ResultVO page(Integer pageNum, Integer pageSize);


}
