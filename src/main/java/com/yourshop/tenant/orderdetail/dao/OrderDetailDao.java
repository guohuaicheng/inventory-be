package com.yourshop.tenant.orderdetail.dao;

import com.yourshop.tenant.orderdetail.model.OrderDetail;

/**
 * @author G
 */
public interface OrderDetailDao {
    /**
     * 插入一条订单
     * @param orderDetail
     */
    void insert(OrderDetail orderDetail);
}
