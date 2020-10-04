package com.imsteam.sell.entity.product.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.imsteam.sell.enums.order.OrderStatusEnum;
import com.imsteam.sell.enums.pay.PayStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderMaster {
    /**
     * 订单id
     */
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家手机号
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信OpenId
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderName;

    /**
     * 订单状态，默认为新下单
     */
    private Integer OrderStatus = OrderStatusEnum.NEW_ORDER.getCode();

    /**
     * 支付状态， 默认为0等待支付
     */
    private Integer payStatus = PayStatusEnum.WAIT_PAY.getCode();

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;





}
