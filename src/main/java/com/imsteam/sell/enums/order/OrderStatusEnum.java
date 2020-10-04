package com.imsteam.sell.enums.order;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

    NEW_ORDER(0,"新订单"),
    FINISHED_ORDER(1,"完结"),
    CANCEL_ORDER(2,"已取消"),
    ;

    private Integer code;
    private String status;

    OrderStatusEnum(Integer code, String status){
        this.code = code;
        this.status = status;
    }

}
