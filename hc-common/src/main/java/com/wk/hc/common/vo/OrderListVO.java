package com.wk.hc.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderListVO {
    private Integer id;

    /**
     * 订单号
     */
    private String code;

    /**
     * 总价格
     */
    private BigDecimal totalPrice;

    /**
     * 会员ID
     */
    private Integer customerId;

    /**
     * 状态
     */
    private String status;

    /**
     * 下单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 支付方式
     */
    private String payType;
    private Integer orderId;

    /**
     * 商品ID
     */


    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收货电话
     */
    private String conTel;


}
