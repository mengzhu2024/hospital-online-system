package com.wk.hc.common.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderVO {
    private Integer id;

    private String code;

    private BigDecimal totalPrice;

    private Integer patientId;

    private String status;

    private LocalDateTime createTime;

    private String payType;

    private List<CartVO> products;
}
