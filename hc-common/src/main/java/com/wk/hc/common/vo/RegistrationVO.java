package com.wk.hc.common.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RegistrationVO {
    private Integer id;

    private String number;

    private Integer userId;

    private Integer patientId;

    private LocalDate date;

    private String time;

    private String status;

    private String dept;

    private String doctorName;

    private String patientName;

    private BigDecimal price;

    private String isPay;

    private String doctorAvatar;

    private String patientAvatar;

}
