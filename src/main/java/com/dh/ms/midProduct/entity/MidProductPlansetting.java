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
 * 设备生产计划设定表
 * @TableName mid_product_plansetting
 */
@TableName(value ="mid_product_plansetting")
@Data
public class MidProductPlansetting implements Serializable {
    /**
     * ID索引
     */
    @TableId(value = "id")
    private String id;

    /**
     * 设备地址，如1--16
     */
    @TableField(value = "device_id")
    private String deviceId;

    /**
     * 产品型号唯一id
     */
    @TableField(value = "product_id")
    private String productId;

    /**
     * 计划产量
     */
    @TableField(value = "sche_quantity")
    private Integer scheQuantity;

    /**
     * 班组开始时间
     */
    @TableField(value = "start_time")
    @JsonFormat(timezone = "GMT+8", pattern = "HH:mm:ss")
    private Date startTime;

    /**
     * 班组结束时间
     */
    @TableField(value = "end_time")
    @JsonFormat(timezone = "GMT+8", pattern = "HH:mm:ss")
    private Date endTime;

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