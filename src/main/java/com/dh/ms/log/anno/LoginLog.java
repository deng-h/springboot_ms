package com.dh.ms.log.anno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 登录日志注解
 * @author: dh
 * @create: 2023-01-07
 */

@Retention(RetentionPolicy.RUNTIME) // 指明 BusinessLog 这个注解的声明周期（保持在运行时）
@Target({ElementType.METHOD}) // 指明 BusinessLog 这个注解可标注的位置（标注在方法上）
public @interface LoginLog {
}
