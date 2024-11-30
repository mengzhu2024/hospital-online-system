package com.wk.hc.common.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CartVO {
    private Integer id;

    private Integer medicineId;

    private Integer amount;

    private Integer patientId;

    private LocalDateTime createTime;

    private String name;

    private String code;

    //描述
    private String description;

    //厂家
    private String manufacturer;

    private String imgPath;

    private BigDecimal price;
}
