package com.yourshop.tenant.order.service;

import com.yourshop.tenant.order.model.Order;

/**
 * @author G
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     * @return
     */
    Order createOrder(Order order);
}
