package com.dh.ms.log.state;

/**
 * @description: 日志状态类型
 * @author: dh
 * @create: 2023-01-07
 */
public enum LogType {
    LOGIN("登录日志"),
    LOGIN_FAIL("登录失败日志"),
    LOGOUT("登出日志"),
    BUSINESS_EXCEPTION("业务异常日志"),
    BUSINESS("业务日志");

    String message;

    LogType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
