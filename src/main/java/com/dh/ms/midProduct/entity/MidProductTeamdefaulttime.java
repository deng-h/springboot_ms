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
 * 默认班组时间设定表
 * @TableName mid_product_teamdefaulttime
 */
@TableName(value ="mid_product_teamdefaulttime")
@Data
public class MidProductTeamdefaulttime implements Serializable {
    /**
     * 班组索引
     */
    @TableId(value = "id")
    private String id;

    /**
     * 班组类型如白班的标记1，夜班标记2
     */
    @TableField(value = "team_type")
    private String teamType;

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