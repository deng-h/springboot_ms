package com.dh.ms.uav.form;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CameraStateForm {
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
     * 对应摄像头编号
     */
    @TableField(value = "camera_id")
    private String cameraId;

    /**
     * 每个摄像头对应的url地址
     */
    @TableField(value = "camera_url")
    private String cameraUrl;
}
