package com.dh.ms.filter;

import cn.hutool.core.util.StrUtil;
import com.dh.ms.common.result.ResultCode;
import com.dh.ms.security.jwt.JwtTokenManager;
import com.dh.ms.utils.ResponseUtils;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//OncePerRequestFilter 顾名思义，它能够确保在一次请求中只通过一次filter，而不会重复执行
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String TOKEN_PREFIX = "Bearer ";
    private final JwtTokenManager jwtTokenManager;

    public JwtAuthenticationFilter(JwtTokenManager jwtTokenManager){
        this.jwtTokenManager = jwtTokenManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(HttpMethod.OPTIONS.matches(request.getMethod())){
            // 放行
            filterChain.doFilter(request, response);
            return;
        }

        // token前缀是Bearer 剥离Bearer获得真正的token信息
        String jwt = resolveToken(request);
        if (StrUtil.isNotBlank(jwt) && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                this.jwtTokenManager.validateToken(jwt);
                Authentication authentication = this.jwtTokenManager.getAuthentication(jwt);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
            }catch (Exception e){
                System.out.println(e.getMessage());
                ResponseUtils.writeErrMsg(response, ResultCode.TOKEN_INVALID_OR_EXPIRED);
            }
        }else {
            ResponseUtils.writeErrMsg(response, ResultCode.TOKEN_INVALID_OR_EXPIRED);
        }
    }

    /**
     * Get token from header.
     */
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StrUtil.isNotBlank(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }
}
