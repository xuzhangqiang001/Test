package com.imsteam.sell.enums.product;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {

    UP_PRODUCT(0,"在架"),
    DOWN_PRODUCT(1,"下架"),
    ;

    private Integer code;
    private String status;

    ProductStatusEnum(Integer code, String status){
        this.code = code;
        this.status = status;
    }

}
