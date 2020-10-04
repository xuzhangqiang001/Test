package com.imsteam.sell.controller;

import com.imsteam.sell.common.vo.ResponseVO;
import com.imsteam.sell.entity.product.info.ProductInfo;
import com.imsteam.sell.service.product.info.ProductInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ProductInfoService productInfoService;

    @PostMapping("/hello")
    public String hello(){
        return "hello 123.";
    }

    @PostMapping("/testSql")
    public ResponseVO testSql(@Param("productId") String productId){
        ResponseVO responseVO = new ResponseVO();

        ProductInfo productInfo = productInfoService.queryProductInfo(productId);
        responseVO.setCode(0);
        responseVO.setMsg("成功");
        responseVO.setData(productInfo);
        return responseVO;
    }
}
