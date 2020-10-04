package com.imsteam.sell.controller;

import com.imsteam.sell.common.utils.ResponseEnum;
import com.imsteam.sell.common.utils.ResponseVOUtil;
import com.imsteam.sell.common.vo.ResponseVO;
import com.imsteam.sell.service.product.ProductVOService;
import com.imsteam.sell.service.product.category.ProductCategoryService;
import com.imsteam.sell.service.product.info.ProductInfoService;
import com.imsteam.sell.vo.ProductInfoVO;
import com.imsteam.sell.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
@Slf4j
public class BuyerProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductVOService productVOService;

    @PostMapping("/addProductInfo")
    public ResponseVO addProductInfo(){
        ResponseVO responseVO = new ResponseVO();
        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();

        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));

//        responseVO.setCode(ResponseEnum.SUCCESS);
//        responseVO.setMsg(ResponseEnum.SUCCESS);
        responseVO.setData(Arrays.asList(productVO));
//        responseVO.setCode(0);
//        responseVO.setMsg("成功");
        return responseVO;
    }

//    public ResponseVO addProductInfo(@RequestBody ProductInfo productInfo){
//        log.info("ProductInfoController addProductInfo info, productInfo:{}", JSON.toJSONString(productInfo));
//        if (ObjectUtils.isEmpty(productInfo)){
//            log.error("ProductInfoController addProductInfo, error:{}, productInfo:{}", ResponseEnum.PARAM_ERROR, JSON.toJSONString(productInfo));
//            return ResponseEnum.PARAM_ERROR;
//        }
//        if (StringUtils.isEmpty(productInfo.getProductName()) || StringUtils.isEmpty(productInfo.getProductPrice())
//                || productInfo.getProductStock()==null ||StringUtils.isEmpty(productInfo.getProductIcon())
//                || StringUtils.isEmpty(productInfo.getProductStatus()) || productInfo.getCategoryType()==null){
//            log.error("ProductInfoController addProductInfo, error:{}, productInfo:{}, productName:{}, productPrice:{}, " +
//                    "productStock:{}, productIcon:{}, productStatus:{}, categoryType:{}", ResponseEnum.PARAM_ERROR,
//                    JSON.toJSONString(productInfo), productInfo.getProductName(), productInfo.getProductPrice(),
//                    productInfo.getProductStock(), productInfo.getProductIcon(), productInfo.getProductStatus(),
//                    productInfo.getCategoryType());
//            return ResponseEnum.PARAM_ERROR;
//        }
//        try {
//            productInfoService.addProductInfo(productInfo);
//        }catch(Exception e){
//            log.error("ProductInfoController addProductInfo, error:{}", ResponseEnum.ERROR);
//            return ResponseEnum.ERROR;
//        }
//        return ResponseEnum.SUCCESS;

    @PostMapping("/queryProductList")
    public ResponseVO queryProductList(@Param("productStatus") Integer productStatus){
        if (productStatus==null){
            ResponseVO responseVO = new ResponseVO();
            responseVO.setCode(ResponseEnum.PARAM_ERROR.getCode());
            responseVO.setMsg(ResponseEnum.PARAM_ERROR.getMsg());
            responseVO.setData(ResponseEnum.PARAM_ERROR);
            return responseVO;
        }
        List<ProductVO> productVOList = productVOService.queryProductVOByProductStatus(productStatus);
        return ResponseVOUtil.success(productVOList);
    }

}
