package com.imsteam.sell.common.utils;

import com.imsteam.sell.common.vo.ResponseVO;

public class ResponseVOUtil {
    /**
     * 操作成功，有数据
     */
    public static ResponseVO success(Object object){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(0);
        responseVO.setMsg("成功");
        responseVO.setData(object);
        return responseVO;
    }

    /**
     * 操作成功，无数据
     */
    public static ResponseVO success(){
        return success(null);
    }

    public static ResponseVO error(Integer code, String msg){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(code);
        responseVO.setMsg(msg);
        return responseVO;
    }
}
