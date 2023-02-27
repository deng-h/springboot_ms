package com.dh.ms.log.factory;

import com.dh.ms.log.entities.LogLogin;
import com.dh.ms.log.entities.LogOperation;
import com.dh.ms.mapper.LogLoginMapper;
import com.dh.ms.mapper.LogOperationMapper;
import com.dh.ms.log.state.LogSucceed;
import com.dh.ms.log.state.LogType;
import com.dh.ms.mapper.system.SysUserMapper;
import com.dh.ms.utils.HttpContext;
import com.dh.ms.utils.SpringContextHolder;

/**
 * @description: 日志操作任务工厂
 * @author: dh
 * @create: 2023-01-07
 */
public class LogTaskFactory {
    private static final SysUserMapper sysUserMapper = SpringContextHolder.getBean(SysUserMapper.class);
    private static final LogLoginMapper logLoginMapper = SpringContextHolder.getBean(LogLoginMapper.class);
    private static final LogOperationMapper logOperationMapper = SpringContextHolder.getBean(LogOperationMapper.class);

    // 登录成功日志
    public static void loginSuccessLog(String username) {
        handle(LogType.LOGIN, LogSucceed.SUCCESS, username);
    }

    // 登录失败日志
    public static void loginUnSuccessLog(String username) {
        handle(LogType.LOGIN_FAIL, LogSucceed.FAIL, username);
    }

    // 登出日志
    public static void logOutLog(String username) {
        handle(LogType.LOGOUT, LogSucceed.SUCCESS, username);
    }

    // 业务日志
    public static void businessLog(LogType logType, String logName, String username,
                                   final String userId, final String className, final String methodName,
                                   LogSucceed logSucceed, final String message) {

        LogOperation operationLog = LogObjectFactory.createOperationLog(logType, logName, username, userId,
                className, methodName, logSucceed, message);

        logOperationMapper.insert(operationLog);  // 将"操作日志对象"插入到数据库的log_operation表中
    }

    private static void handle(LogType logType, LogSucceed logSucceed, String username) {
        String userId = username == null ? null : sysUserMapper.getIdByUsername(username);
        String ipAddress = HttpContext.getIp();

        LogLogin loginLog = LogObjectFactory.createLoginLog(logType, username, userId, logSucceed, ipAddress, null);

        logLoginMapper.insert(loginLog);  // 将"登录/登出日志对象"插入到数据库的log_login表中
    }
}
