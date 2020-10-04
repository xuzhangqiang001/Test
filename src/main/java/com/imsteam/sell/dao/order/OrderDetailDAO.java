package com.imsteam.sell.dao.order;

import com.imsteam.sell.entity.product.order.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * order_master表中一条记录可能对应order_detail表的多条记录
 */
@Mapper
@Repository
public interface OrderDetailDAO {

    /**
     * 根据订单id查询订单详情信息。 order_master表中一条记录可能对应order_detail表的多条记录
     * @param orderId
     * @return
     */
    List<OrderDetail> queryByOrderId(String orderId);
}
