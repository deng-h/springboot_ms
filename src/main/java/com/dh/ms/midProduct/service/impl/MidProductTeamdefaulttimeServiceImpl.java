package com.dh.ms.midProduct.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.common.result.Result;
import com.dh.ms.midProduct.entity.MidProductTeamdefaulttime;
import com.dh.ms.midProduct.service.MidProductTeamdefaulttimeService;
import com.dh.ms.mapper.midProduct.MidProductTeamdefaulttimeMapper;
import org.springframework.stereotype.Service;

/**
* @author Lenovo
* @description 针对表【mid_product_teamdefaulttime(默认班组时间设定表)】的数据库操作Service实现
* @createDate 2023-02-22 10:39:50
*/
@Service
public class MidProductTeamdefaulttimeServiceImpl extends ServiceImpl<MidProductTeamdefaulttimeMapper, MidProductTeamdefaulttime>
    implements MidProductTeamdefaulttimeService{

    @Override
    public Result getDataByTeamType(String teamType) {
        MidProductTeamdefaulttime result = this.getOne(new LambdaQueryWrapper<MidProductTeamdefaulttime>()
                .eq(MidProductTeamdefaulttime::getTeamType, teamType));
        if(result != null){
            return Result.success(result);
        }else {
            return Result.failed("没有此数据");
        }
    }

    @Override
    public boolean updateTeamDefaultTime(MidProductTeamdefaulttime teamDefaultTime) {
        MidProductTeamdefaulttime midProductTeamdefaulttime = new MidProductTeamdefaulttime();
        midProductTeamdefaulttime.setId(teamDefaultTime.getId());
        midProductTeamdefaulttime.setStartTime(teamDefaultTime.getStartTime());
        midProductTeamdefaulttime.setEndTime(teamDefaultTime.getEndTime());
        midProductTeamdefaulttime.setGmtModified(DateUtil.date());
        boolean b = this.updateById(midProductTeamdefaulttime);
        return b;
    }
}




