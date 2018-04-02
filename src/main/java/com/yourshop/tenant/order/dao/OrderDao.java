package com.yourshop.tenant.order.dao;

import com.yourshop.tenant.order.model.Order;

/**
 * @author G
 */
public interface OrderDao {
    /**
     * 创建订单
     * @param order
     * @return
     */
    int insert(Order order);
}
