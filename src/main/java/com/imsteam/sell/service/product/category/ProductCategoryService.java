package com.imsteam.sell.service.product.category;

import com.imsteam.sell.entity.product.category.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 根据类目Id查询
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 根据类目编号查询
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryType(List<Integer> categoryTypeList);

    /**
     * 保存到数据库
     * @param productCategory
     * @return
     */
    void insertProductCategoryInfo(ProductCategory productCategory);
}
