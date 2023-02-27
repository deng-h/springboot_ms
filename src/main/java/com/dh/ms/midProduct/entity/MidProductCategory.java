package com.dh.ms.midProduct.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 产品分类表
 * @TableName mid_product_category
 */
@TableName(value ="mid_product_category")
@Data
public class MidProductCategory implements Serializable {
    /**
     * 产品分类ID索引
     */
    @TableId(value = "id")
    private String id;

    /**
     * 产品分类名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableField(value = "is_deleted")
    @TableLogic
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date gmtModified;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}