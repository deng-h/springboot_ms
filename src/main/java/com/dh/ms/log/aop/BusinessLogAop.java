package com.dh.ms.log.aop;

import com.dh.ms.log.anno.BusinessLog;
import com.dh.ms.log.factory.LogTaskFactory;
import com.dh.ms.log.state.LogSucceed;
import com.dh.ms.log.state.LogType;
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

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @description: 执行业务日志的AOP切面类
 * @author: dh
 * @create: 2023-01-07
 */

@Component
@Aspect
@Order(Integer.MIN_VALUE) // 将BusinessLogAop的执行优先级高于@Transactional（事务），即对于相同的代理对象，BusinessLogAop的代理操作
public class BusinessLogAop {

    @Autowired
    SysUserMapper sysUserMapper;

    // 抽取有相同特征的切入点（方法）： 随便定义一个方法，并定义切入点表达式
    @Pointcut(value = "@annotation(com.dh.ms.log.anno.BusinessLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordBusinessLog(ProceedingJoinPoint point) throws Throwable {
        System.out.println("开始执行BusinessLogAop的recordBusinessLog方法");
        Object result = null;
        try {
            beforeHandle(point);
            result = point.proceed();  // 代理执行切入点方法
            afterReturningHandle(point);
        } catch (Exception e){
            exceptionHandle(point, e);
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
//        System.out.println("BusinessLogAop的beforeHandle方法中的【前置通知】");
    }

    /**
     * 返回通知处理方法(出现异常抛出后，不执行)
     * @param point 切入点对象
     * @throws Exception 异常信息
     */
    private void afterReturningHandle(ProceedingJoinPoint point) throws Exception {
//        System.out.println("BusinessLogAop的afterReturningHandle方法中的【返回通知】");
        handle(point, LogType.BUSINESS, LogSucceed.SUCCESS, null);
    }

    /**
     * 异常通知处理方法
     * @param point 切入点对象
     * @param exception 捕获的异常
     * @throws Exception 异常信息
     */
    private void exceptionHandle(ProceedingJoinPoint point, Exception exception) throws Exception {
//        System.out.println("BusinessLogAop的exceptionHandle方法中的【异常通知】");
        handle(point, LogType.BUSINESS_EXCEPTION, LogSucceed.FAIL, exception);
    }

    /**
     * 后置通知处理方法
     * @param point 切入点对象
     * @throws Exception 异常信息
     */
    private void afterHandle(ProceedingJoinPoint point) throws Exception {
//        System.out.println("BusinessLogAop的afterHandle方法中的【后置通知】");
    }


    private void handle(ProceedingJoinPoint point, LogType logType, LogSucceed logSucceed, Exception exception) throws Exception {
        Signature sig = point.getSignature();  // 获取切入点方法的签名 修饰符+包名(全路径)+类名+方法名(形参类型)
        MethodSignature methodSig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }

        methodSig = (MethodSignature) sig;

        // 若当前用户未登录，不做日志
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            System.out.println("BusinessLogAop的handle方法中的用户未登录");
            return;
        }

        Class<?> pointCutClass = point.getTarget().getClass();  // 返回类名全路径
        Method pointCutMethod = pointCutClass.getMethod(methodSig.getName(), methodSig.getParameterTypes());
        BusinessLog annotation = pointCutMethod.getAnnotation(BusinessLog.class);  // 得到此方法上的@BusinessLog注解

//        System.out.println("BusinessLogAop的handle方法中的authentication: " + authentication);

        String logName = annotation.value();
        String username = authentication.getName();
        String userId  = sysUserMapper.getIdByUsername(username);
        String className = pointCutClass.getName();
        String methodName = pointCutMethod.getName();
        String message = logType.getMessage().equals(LogType.BUSINESS_EXCEPTION.getMessage()) ?
                getMessage(exception) : getMessage(methodName, point.getArgs());
        LogTaskFactory.businessLog(logType, logName, username, userId, className, methodName, logSucceed, message);
    }

    /**
     * 根据方法名称返回对应备注
     * @param methodName 方法名称
     * @param args 方法上的参数对象列表
     * @return 备注
     */
    private String getMessage(String methodName, Object[] args) {
        StringBuilder message = new StringBuilder();

        if (methodName.contains("add") || methodName.contains("insert") || methodName.contains("save")) {
            message.append("添加的数据: ");
        } else if (methodName.contains("delete") || methodName.contains("remove")) {
            message.append("删除数据的id: ");
        } else if (methodName.contains("edit") || methodName.contains("update")) {
            message.append("用于更新的数据: ");
        }else {
            message.append("调用的方法参数为: ");
        }
        message.append(Arrays.toString(args));

        return message.toString();
    }

    /**
     * 返回异常信息备注
     * @param e 方法上的参数对象列表
     * @return 备注
     */
    private String getMessage(Exception e) {
        return e.getMessage();
    }
}
