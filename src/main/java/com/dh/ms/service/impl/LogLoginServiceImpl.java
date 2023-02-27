package com.dh.ms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dh.ms.log.entities.LogLogin;
import com.dh.ms.service.LogLoginService;
import com.dh.ms.mapper.LogLoginMapper;
import org.springframework.stereotype.Service;

/**
* @author dh
* @description 针对表【log_login】的数据库操作Service实现
* @createDate 2023-01-07 10:39:58
*/
@Service
public class LogLoginServiceImpl extends ServiceImpl<LogLoginMapper, LogLogin>
    implements LogLoginService{

}




