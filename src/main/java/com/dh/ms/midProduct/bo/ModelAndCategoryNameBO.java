package com.dh.ms.midProduct.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 初产库存表
 */


@Getter
@Setter
public class ModelAndCategoryNameBO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String productId;
    private String name;
    private String categoryName;
}
