package com.dh.ms.websocket;

import com.alibaba.fastjson2.JSONObject;
import com.dh.ms.vo.ResultVO;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ServerEncoder implements Encoder.Text<ResultVO> {
    /**
     * 这里的参数 resultVO要和Encoder.Text<T>保持一致
     * @param resultVO
     * @throws EncodeException
     */
    @Override
    public String encode(ResultVO resultVO) throws EncodeException {
//        返回Object序列化后的json字符串就行  这里使用fastjson
        try {
            return JSONObject.toJSONString(resultVO);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
