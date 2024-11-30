package com.wk.hc.common.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DoctorVO {
    private Integer id;

    private String username;

    private String password;

    private String tel;

    private String name;

    private LocalDateTime createTime;

    private String avatar;

    private String role;

    private String status;

    private String sex;

    private String title;

    private Integer deptId;

    private String dept;

    private BigDecimal price;
}
