package com.imsteam.sell.service.product;

import com.imsteam.sell.vo.ProductVO;

import java.util.List;

/**
 * @FUNCTION：
 * @Author： asus
 * @Date： 2020/10/2 17:35
 */
public interface ProductVOService {
    List<ProductVO> queryProductVOByProductStatus(Integer productStatus);
}
