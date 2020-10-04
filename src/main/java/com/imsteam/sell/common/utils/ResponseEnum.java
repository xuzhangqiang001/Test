package com.imsteam.sell.common.utils;

public enum ResponseEnum {

    SUCCESS(0,"操作成功！"),
    ERROR(500,"操作失败，服务器开小差了！"),
    PARAM_ERROR(501,"参数校验错误"),
    ACCESS_TIMEOUT(502,"访问超时"),
    ;
    private Integer code;
    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        if (this.code == SUCCESS.getCode()){
            return SUCCESS.getCode();
        }
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
