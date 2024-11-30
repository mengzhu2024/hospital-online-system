package com.wk.hc.common.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("medicine")
public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 分类
     */
    private Integer categoryId;

    /**
     * 描述
     */
    private String description;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 适应症
     */
    private String Indications;

    /**
     * 用法用量
     */
    private String dosage;

    /**
     * 禁忌
     */
    private String taboo;

    /**
     * 注意事项
     */
    private String adverseEffects;

    /**
     * 保质期
     */
    private String expirationDate;

    private String imgPath;

    private String status;

    /**
     * 价格
     */
    private BigDecimal price;


}
