package com.dh.ms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.log.entities.LogOperation;
import com.dh.ms.service.LogOperationService;
import com.dh.ms.mapper.LogOperationMapper;
import org.springframework.stereotype.Service;

/**
* @author dh
* @description 针对表【log_operation】的数据库操作Service实现
* @createDate 2023-01-07 10:41:27
*/
@Service
public class LogOperationServiceImpl extends ServiceImpl<LogOperationMapper, LogOperation>
    implements LogOperationService{

}




