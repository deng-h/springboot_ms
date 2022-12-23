package com.dh.ms.common.base;

import lombok.*;

/**
 * 基础分页请求对象
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BasePageQuery {
    private int pageNum = 1;
    private int pageSize = 10;
}
