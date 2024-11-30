package com.wk.hc.common.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryVo {
    private Integer id;

    private String number;

    private Integer userId;

    private Integer patientId;

    private String content;

    private String advice;

    private LocalDateTime time;

    private String dept;

    private String doctorName;

    private String patientName;

    private String timeString;

    private String doctorAvatar;

    private String patientAvatar;

}
