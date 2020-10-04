package com.imsteam.sell.service.product.impl;

import com.imsteam.sell.entity.product.category.ProductCategory;
import com.imsteam.sell.entity.product.info.ProductInfo;
import com.imsteam.sell.service.product.ProductVOService;
import com.imsteam.sell.service.product.category.ProductCategoryService;
import com.imsteam.sell.service.product.info.ProductInfoService;
import com.imsteam.sell.vo.ProductInfoVO;
import com.imsteam.sell.vo.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @FUNCTION：
 * @Author： asus
 * @Date： 2020/10/2 17:35
 */

@Service
public class ProductVOServiceImpl implements ProductVOService {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    public List<ProductVO> queryProductVOByProductStatus(Integer productStatus){

        //1.查询所有上架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll(productStatus);

        //2.查询类目（一次性查询）
        //传统方法
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo : productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法(java8, lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(n -> n.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList= productCategoryService.findByCategoryType(categoryTypeList);
        if (CollectionUtils.isEmpty(productCategoryList)){
            return null;
        }

        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        List<ProductInfoVO> productInfoVOList = new ArrayList<>();

        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            for (ProductInfo productInfo : productInfoList){
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //传统方法
//                    productInfoVO.setProductId(productInfo.getProductId());
//                    productInfoVO.setProductName(productInfo.getProductName());
//                    productInfoVO.setProductPrice(productInfo.getProductPrice());
//                    productInfoVO.setProductDescription(productInfo.getProductDescription());
//                    productInfoVO.setProductIcon(productInfo.getProductIcon());
                    //SpringBoot新方法
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);

                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return productVOList;
    }
}
