package com.imsteam.sell.entity.product.category;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * dataobject:也命名为dto
 *
 * 类目表product_category实体类
 * Created by Max
 * 2020-09-23 01:19
 * 若想表名和类名不一致，可用@Table(name = "product_category")映射，再取和表名不一样的类名。
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = -6142001437978576576L;

    /**
     * 类目id  @Id：表明是主键，  @GeneratedValue(strategy = GenerationType.IDENTITY):表明为自增类型
     */
    private Integer categoryId;

    /**
     * 类目名字
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime;
}
