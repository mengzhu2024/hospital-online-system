package com.wk.hc.common.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class IndexMedicineVO {

    private String name;
    private String imgPath;
    private BigDecimal price;
    private String description;
    private String category;
    private Integer id;

}
