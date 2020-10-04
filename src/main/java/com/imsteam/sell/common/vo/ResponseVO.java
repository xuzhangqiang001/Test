package com.imsteam.sell.common.vo;

import lombok.Data;

@Data
public class ResponseVO<T> {

    /**
     * 状态码。0成功， 1失败
     */
    private Integer code;

    /**
     * 提示信息。
     */
    private String msg;

    /**
     * 返回的具体内容
     */
    private T data;
}
