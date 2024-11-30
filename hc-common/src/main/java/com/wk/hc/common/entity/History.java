package com.wk.hc.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("history")
public class History implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 编号
     */
    private String number;

    /**
     * 医生
     */
    private Integer userId;

    /**
     * 患者
     */
    private Integer patientId;

    /**
     * 病情
     */
    private String content;

    /**
     * 医嘱
     */
    private String advice;

    /**
     * 时间
     */
    private LocalDateTime time;


}
