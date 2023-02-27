package com.dh.ms.midProduct.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/*
 * 设备生产计划设定表
 */
@Getter
@Setter
public class MidPlanSettingBO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String deviceId;

    private String productId;

    private String model;

    private String name;

    private String cname;

    private Integer scheQuantity;

    @JsonFormat(timezone = "GMT+8", pattern = "HH:mm:ss")
    private Date startTime;

    @JsonFormat(timezone = "GMT+8", pattern = "HH:mm:ss")
    private Date endTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date gmtCreate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date gmtModified;
}
