package com.dh.ms.uav.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * uav_camera_state
 * @TableName uav_camera_state
 */
@TableName(value ="uav_camera_state")
@Data
public class UavCameraState implements Serializable {
    /**
     * ID索引
     */
    @TableId(value = "id")
    private String id;

    /**
     * 分类id,与机库id相关联
     */
    @TableField(value = "category_id")
    private String categoryId;

    /**
     * 分组名称,与机库hangar_category相关联
     */
    @TableField(value = "category_name")
    private String categoryName;

    /**
     * 对应摄像头编号
     */
    @TableField(value = "camera_id")
    private String cameraId;

    /**
     * 每个摄像头对应的url地址
     */
    @TableField(value = "camera_url")
    private String cameraUrl;

    /**
     * 每个摄像头对应的accesstoken一个账户的都是同个
     */
    @TableField(value = "camera_access_token")
    private String cameraAccessToken;

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
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}