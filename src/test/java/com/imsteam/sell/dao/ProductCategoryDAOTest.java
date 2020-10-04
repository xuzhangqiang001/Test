package com.imsteam.sell.dao;

import com.imsteam.sell.entity.product.category.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDAOTest {

    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryDAO.findOne(1);
        System.out.println(productCategory.toString());
    }

    /**
     * @Transactional:在测试中，所作的事情会回滚。
     */
    @Test
    @Transactional(rollbackFor = RuntimeException.class)
    public void insertProductCategoryInfoTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(100);
        productCategoryDAO.insertProductCategoryInfo(productCategory);
    }

    /**
     * 根据类目编号查询类目表
     */
    @Test
    public void findByCategoryTypeInTest(){

    }
}