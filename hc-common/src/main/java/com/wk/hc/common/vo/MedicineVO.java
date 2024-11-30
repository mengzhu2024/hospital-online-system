package com.wk.hc.common.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MedicineVO {
    private Integer id;

    private String name;

    private String code;

    private Integer categoryId;

    private String category;

    private String description;

    private String manufacturer;

    private String Indications;

    private String dosage;

    private String taboo;

    private String adverseEffects;

    private String expirationDate;

    private String imgPath;

    private String status;

    private BigDecimal price;

}
