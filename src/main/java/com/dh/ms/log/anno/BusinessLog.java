package com.dh.ms.log.anno;

import java.lang.annotation.*;

/**
 * @description: 业务日志注解
 * @author: dh
 * @create: 2023-01-07
 */

@Inherited // 指明 BusinessLog 这个注解是可继承的
@Retention(RetentionPolicy.RUNTIME) // 指明 BusinessLog 这个注解的声明周期（保持在运行时）
@Target({ElementType.METHOD}) // 指明 BusinessLog 这个注解可标注的位置（标注在方法上）
public @interface BusinessLog {
    /**
     * 业务的名称,例如:"添加排单"
     */
    String value() default "";

    /*
     * 被修改的实体的唯一标识,例如:菜单实体的唯一标识为"id"
     */
//    String key() default "id";

    /*
     * 字典(用于查找key的中文名称和字段的中文名称)
     */
//    Class<? extends AbstractDictMap> dict() default SystemDict.class;
}
