package com.imsteam.sell.service.product.info;

import com.imsteam.sell.entity.product.info.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    void addProductInfo(ProductInfo productInfo) throws Exception;
    /**
     * 查询所有上架的商品
     * @return
     */
    List<ProductInfo> findUpAll(Integer productStatus);

    ProductInfo queryProductInfo(String productId);
}
