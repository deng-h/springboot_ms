package com.dh.ms.midProduct.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class InitProdStorageBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String productId;

    private Long stocks;

    private String adminName;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date gmtCreate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date gmtModified;

    private String model;

    private String name;

    private String cname;
}
