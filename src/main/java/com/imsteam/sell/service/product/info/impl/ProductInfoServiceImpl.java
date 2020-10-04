package com.imsteam.sell.service.product.info.impl;

import com.imsteam.sell.common.constant.CommonConstant;
import com.imsteam.sell.common.utils.ResponseEnum;
import com.imsteam.sell.dao.ProductInfoDAO;
import com.imsteam.sell.entity.product.info.ProductInfo;
import com.imsteam.sell.service.product.info.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Slf4j
public class ProductInfoServiceImpl implements ProductInfoService {

    /**
     * 变量（field）注入：Idea不推荐
     */
    @Autowired
    private ProductInfoDAO productInfoDAO;

    @Override
//    @Transactional(rollbackFor = RuntimeException.class)
    public void addProductInfo(ProductInfo productInfo) throws Exception{
        log.info("ProductInfoServiceImpl addProductInfo");
        int retryCount = 0;
        while(retryCount < CommonConstant.RETRY_TIMES){
            try {
                productInfoDAO.addProductInfo(productInfo);
                log.info("ProductInfoServiceImpl addProductInfo, info:{}, retryCount:{}", ResponseEnum.SUCCESS, retryCount);
            }catch(Exception e){
                retryCount++;
                if (retryCount > CommonConstant.RETRY_TIMES){
                    log.error("ProductInfoServiceImpl addProductInfo, error:{}, retryCount:{}", ResponseEnum.ACCESS_TIMEOUT, retryCount);
                    throw new Exception();
                }
            }

        }

    }

    /**
     * 根据产品id查询产品信息
     * @param productId
     * @return
     */
    @Override
    public ProductInfo queryProductInfo(String productId){
        ProductInfo productInfo = productInfoDAO.queryProductInfoById(productId);
        return productInfo;
    }

    /**
     * 根据产品状态productStatus查询上架的产品信息
     * @param productStatus
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll(Integer productStatus) {
        List<ProductInfo> productInfoList = productInfoDAO.queryProductInfoByProductStatus(productStatus);
        if (CollectionUtils.isEmpty(productInfoList)){
            return null;
        }
        return productInfoList;
    }
}
