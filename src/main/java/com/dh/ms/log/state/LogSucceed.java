package com.dh.ms.log.state;

/**
 * @description: 业务是否成功的日志记录
 * @author: dh
 * @create: 2023-01-07
 */
public enum LogSucceed {
    SUCCESS("成功"),
    FAIL("失败");

    String message;

    LogSucceed(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
