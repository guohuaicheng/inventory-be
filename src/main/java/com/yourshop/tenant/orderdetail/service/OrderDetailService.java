package com.yourshop.tenant.orderdetail.service;

import com.yourshop.tenant.orderdetail.model.OrderDetail;

/**
 * @author G
 */
public interface OrderDetailService {

    /**
     * 创建一条订单
     * @param orderDetail
     * @return
     */
    OrderDetail createOrderDetail(OrderDetail orderDetail);
}
