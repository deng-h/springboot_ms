package com.dh.ms.pojo.query;

import lombok.*;

/**
 * 菜单查询对象
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuQuery {
    private String keywords;
    private Integer status;
}
