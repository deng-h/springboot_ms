package com.dh.ms.interceptors;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.dh.ms.Utils.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = request.getHeader("Authorization");  //获取请求头中的令牌
        return true;
//        Map<String,Object> map = new HashMap<>();
//        try {
//            JWTUtils.verify(token);
//            return true;  //放行请求
//        } catch (TokenExpiredException e) {
//            map.put("msg", "Token已经过期!");
//        } catch (SignatureVerificationException e){
//            map.put("msg", "签名错误!");
//        } catch (AlgorithmMismatchException e){
//            map.put("msg", "加密算法不匹配!");
//        } catch (Exception e) {
//            e.printStackTrace();
//            map.put("msg", "无效token!");
//        }
//        map.put("code", 401);  // 401 Unauthorized
//        map.put("data", null);   // 设定参考ResultVO
//        String json = new ObjectMapper().writeValueAsString(map);
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().println(json);  //返回给前端
//        return false;
    }
}
