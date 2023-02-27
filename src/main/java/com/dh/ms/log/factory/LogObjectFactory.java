package com.dh.ms.log.factory;

import cn.hutool.core.date.DateUtil;
import com.dh.ms.log.entities.LogLogin;
import com.dh.ms.log.entities.LogOperation;
import com.dh.ms.log.state.LogSucceed;
import com.dh.ms.log.state.LogType;

import java.util.Date;

/**
 * @description: 日志对象工厂
 * @author: dh
 * @create: 2023-01-07
 */
public class LogObjectFactory {

    public static LogOperation createOperationLog(LogType logType, String logName, String username,
                                                  String userId, String className, String methodName,
                                                  LogSucceed succeed, String message) {

        LogOperation logOperation = new LogOperation();
        Date date = DateUtil.date();

        logOperation.setLogType(logType.getMessage());
        logOperation.setLogName(logName);
        logOperation.setUsername(username);
        logOperation.setUserId(userId);
        logOperation.setClassName(className);
        logOperation.setMethodName(methodName);
        logOperation.setSucceed(succeed.getMessage());
        logOperation.setMessage(message);
        logOperation.setGmtCreate(date);

        return logOperation;
    }

    public static LogLogin createLoginLog(LogType logType, String username, String userId,
                                          LogSucceed succeed, String ipAddress, String message){
        LogLogin logLogin = new LogLogin();
        Date date = DateUtil.date();

        logLogin.setLogType(logType.getMessage());
        logLogin.setUsername(username);
        logLogin.setUserId(userId);
        logLogin.setSucceed(succeed.getMessage());
        logLogin.setIpAddress(ipAddress);
        logLogin.setMessage(message);
        logLogin.setGmtCreate(date);

        return logLogin;
    }
}
