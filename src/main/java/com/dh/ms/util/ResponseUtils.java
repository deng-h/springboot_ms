package com.dh.ms.util;

import cn.hutool.json.JSONUtil;
import com.dh.ms.common.result.Result;
import com.dh.ms.common.result.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * response 响应工具类
 *
 */

public class ResponseUtils {
    /**
     * 异常消息返回(适用过滤器异常响应)
     *
     * @param response
     * @param resultCode
     */
    public static void writeErrMsg(HttpServletResponse response, ResultCode resultCode) throws IOException {
        switch (resultCode) {
            case ACCESS_UNAUTHORIZED:
            case TOKEN_INVALID_OR_EXPIRED:
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                break;
            case TOKEN_ACCESS_FORBIDDEN:
                response.setStatus(HttpStatus.FORBIDDEN.value());
                break;
            default:
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                break;
        }
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(JSONUtil.toJsonStr(Result.failed(resultCode)));
    }
}
