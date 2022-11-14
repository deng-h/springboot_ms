package com.dh.ms.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    private static final String TOKEN = "token!Q@W3b1b";  // 密钥

    /**
     * 生成token
     * @param map  //传入payload header采用默认的，所以不写
     * @return 返回token
     */
    public static String getToken(Map<String, String> map){
        Calendar instance = Calendar.getInstance();
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);  // 设置Payload
        });
        instance.add(Calendar.DATE,7);  //指定令牌过期时间 7天过期
        builder.withExpiresAt(instance.getTime());  //设置过期时间
        return builder.sign(Algorithm.HMAC256(TOKEN)).toString();  // 签名
    }

    /**
     * 验证token
     * @param token
     */
    public static void verify(String token){
        //如果验证失败会抛出异常 没有抛出异常就是验证通过
        JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }

    /**
     * 获取token中的payload
     * @param token
     */
    public static DecodedJWT getToken(String token){
        return JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }

}
