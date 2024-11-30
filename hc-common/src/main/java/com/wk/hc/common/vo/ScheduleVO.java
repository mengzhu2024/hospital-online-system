package com.wk.hc.common.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ScheduleVO {
    private Integer id;

    private Integer userId;

    private LocalDate beginDate;

    private LocalDate endDate;

    private Integer maxNum;

    private String username;

    private String tel;

    private String name;

    private String sex;

    private String title;

    private String dept;

    private BigDecimal price;
}
