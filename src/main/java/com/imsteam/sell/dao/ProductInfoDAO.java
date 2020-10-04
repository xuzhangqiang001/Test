package com.imsteam.sell.dao;

import com.imsteam.sell.entity.product.info.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductInfoDAO{

    /**
     * 添加产品信息
     */
    void addProductInfo(ProductInfo productInfo);

    /**
     * 根据产品状态productStatus查询产品信息
     */
    List<ProductInfo> queryProductInfoByProductStatus(Integer productStatus);

    /**
     * 根据产品id查询产品信息
     */
    ProductInfo queryProductInfoById(String product_id);
}

