package com.imsteam.sell.enums.pay;

import lombok.Getter;

@Getter
public enum PayStatusEnum {

    WAIT_PAY(0,"等待支付"),
    SUCCESS_PAY(1,"支付成功"),
    ;

    private Integer code;
    private String status;

    PayStatusEnum(Integer code, String status){
        this.code = code;
        this.status = status;
    }

}
