package com.imsteam.sell.service.product.category.impl;

import com.imsteam.sell.dao.ProductCategoryDAO;
import com.imsteam.sell.entity.product.category.ProductCategory;
import com.imsteam.sell.service.product.category.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 类目实现类Service
 */

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryDAO.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDAO.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryType(List<Integer> categoryTypeList) {
        if (CollectionUtils.isEmpty(categoryTypeList)){
            return null;
        }

        return productCategoryDAO.findByCategoryType(categoryTypeList);
    }

    @Override
    public void insertProductCategoryInfo(ProductCategory productCategory) {
        productCategoryDAO.insertProductCategoryInfo(productCategory);
    }
}
