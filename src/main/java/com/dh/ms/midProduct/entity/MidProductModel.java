package com.dh.ms.midProduct.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 产品型号表
 * @TableName mid_product_model
 */
@TableName(value ="mid_product_model")
@Data
public class MidProductModel implements Serializable {
    /**
     * 产品型号ID索引
     */
    @TableId(value = "id")
    private String id;

    /**
     * 产品型号
     */
    @TableField(value = "model")
    private String model;

    /**
     * 产品名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 产品所属分类
     */
    @TableField(value = "category_id")
    private String categoryId;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableField(value = "is_deleted")
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