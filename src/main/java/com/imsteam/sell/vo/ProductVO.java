package com.imsteam.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品（包含类目）
 */
@Data
public class ProductVO {

    /**
     * 类目名字
     * @JsonProperty:其value值即为返回给前端的值name
     */
    @JsonProperty("name")
    private String categoryName;

    /**
     * 类目编号
     */
    @JsonProperty("type")
    private Integer categoryType;

    /**
     *
     */
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
