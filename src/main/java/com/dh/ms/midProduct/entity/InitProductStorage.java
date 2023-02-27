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
 * 初产库存表
 * @TableName init_product_storage
 */
@TableName(value ="init_product_storage")
@Data
public class InitProductStorage implements Serializable {
    /**
     * 初产入库ID索引
     */
    @TableId(value = "id")
    private String id;

    /**
     * 产品型号唯一id
     */
    @TableField(value = "product_id")
    private String productId;

    /**
     * 库存
     */
    @TableField(value = "stocks")
    private Long stocks;

    /**
     * 库存数据的管理员名
     */
    @TableField(value = "admin_name")
    private String adminName;

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