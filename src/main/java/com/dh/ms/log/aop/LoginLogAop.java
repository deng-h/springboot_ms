package com.dh.ms.log.aop;

import com.dh.ms.log.factory.LogTaskFactory;
import com.dh.ms.log.state.LogSucceed;
import com.dh.ms.mapper.system.SysUserMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;



/**
 * @description: 登录日志的AOP切面类
 * @author: dh
 * @create: 2023-01-09
 */

@Component
@Aspect
@Order(Integer.MIN_VALUE)
public class LoginLogAop {

    @Autowired
    SysUserMapper sysUserMapper;

    // 抽取有相同特征的切入点（方法）： 随便定义一个方法，并定义切入点表达式
    @Pointcut(value = "@annotation(com.dh.ms.log.anno.LoginLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordBusinessLog(ProceedingJoinPoint point) throws Throwable {
//        System.out.println("开始执行LoginLogAop的recordBusinessLog方法");
        Object result = null;
        try {
            beforeHandle(point);
            result = point.proceed();  // 代理执行切入点方法
            afterReturningHandle(point);
        }catch (Exception e){
            exceptionHandle(point);
            throw new RuntimeException(e);
        }finally {
            afterHandle(point);
        }
        return result;
    }

    /**
     * 前置通知处理方法
     * @param point 切入点对象
     * @throws Exception 异常信息
     */
    private void beforeHandle(ProceedingJoinPoint point) throws Exception {
//        System.out.println("LoginLogAop的beforeHandle方法中的【前置通知】");
    }

    /**
     * 返回通知处理方法(出现异常抛出后，不执行)
     * @param point 切入点对象
     * @throws Exception 异常信息
     */
    private void afterReturningHandle(ProceedingJoinPoint point) throws Exception {
//        System.out.println("LoginLogAop的afterReturningHandle方法中的【返回通知】");
        handle(point, LogSucceed.SUCCESS);
    }

    /**
     * 异常通知处理方法
     * @param point 切入点对象
     * @throws Exception 异常信息
     */
    private void exceptionHandle(ProceedingJoinPoint point) throws Exception {
//        System.out.println("LoginLogAop的exceptionHandle方法中的【异常通知】");
        handle(point, LogSucceed.FAIL);
    }

    /**
     * 后置通知处理方法
     * @param point 切入点对象
     * @throws Exception 异常信息
     */
    private void afterHandle(ProceedingJoinPoint point) throws Exception {
//        System.out.println("LoginLogAop的afterHandle方法中的【后置通知】");
    }

    private void handle(ProceedingJoinPoint point, LogSucceed logSucceed) throws Exception {
        Signature sig = point.getSignature();  // 获取切入点方法的签名 修饰符+包名(全路径)+类名+方法名(形参类型)
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        if(logSucceed.equals(LogSucceed.SUCCESS)){
            LogTaskFactory.loginSuccessLog(username);
        }else {
            LogTaskFactory.loginUnSuccessLog(username);
        }
    }
}
