package com.dh.ms.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// code 后端向前端返回数据时的状态码
// msg 消息提示
// data 返回的数据
public class ResultVO {
    private Integer code;
    private String msg;
    private Object data;
    public static ResultVO success(String msg){
        return new ResultVO(200, msg, null);
    }

    public static ResultVO success(String msg, Object obj){
        return new ResultVO(200, msg, obj);
    }

    public static ResultVO success(String msg, Integer code){
        return new ResultVO(code, msg, null);
    }

    public static ResultVO error(String msg, Object obj){
        return new ResultVO(500, msg, obj);
    }

    public static ResultVO error(String msg){
        return new ResultVO(500, msg, null);
    }

    public static ResultVO error(String msg, Integer code){
        return new ResultVO(code, msg, null);
    }
}
