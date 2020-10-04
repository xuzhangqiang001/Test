package com.imsteam.sell.dao.order;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface OrderMasterDAO {

    /**
     * 根据买家端的openid查询订单详情信息
     * @param buyerOpenid
     * @param pageable
     * @return
     */
//    Page<OrderMaster> queryByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
