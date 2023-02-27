package com.dh.ms.uav.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * UavCameraHangar
 * @TableName uav_camera_hangar
 */
@TableName(value ="uav_camera_hangar")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UavCameraHangar implements Serializable {
    /**
     * ID索引,唯一编号作为摄像头的分组依据
     */
    @TableId(value = "id")
    private String id;

    /**
     * 对应机库分组名称
     */
    @TableField(value = "hangar_category")
    private String hangarCategory;

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