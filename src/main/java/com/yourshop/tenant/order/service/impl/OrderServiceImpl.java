package com.yourshop.tenant.order.service.impl;

import com.yourshop.core.runtime.user.TenantContextUtil;
import com.yourshop.tenant.order.dao.OrderDao;
import com.yourshop.tenant.order.model.Order;
import com.yourshop.tenant.order.service.OrderService;
import com.yourshop.tenant.orderdetail.dao.OrderDetailDao;
import com.yourshop.tenant.orderdetail.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @author G
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Order createOrder(Order order) {
        if(order == null) {

        }
        String id = UUID.randomUUID().toString();
        String tenantId = TenantContextUtil.getTenant().getId();
        order.setId(id);
        order.setCreatedTime(new Date(System.currentTimeMillis()));
//        order.setVipId();
        order.setTenantId(tenantId);
        this.orderDao.insert(order);
        OrderDetail[] orderDetails = order.getOrderDetails();
        if(orderDetails != null && orderDetails.length > 0) {
            for(OrderDetail orderDetail : orderDetails) {
                orderDetail.setId(UUID.randomUUID().toString());
                orderDetail.setOrderId(id);
                orderDetail.setTenantId(tenantId);
                orderDetailDao.insert(orderDetail);
            }
        }
        return order;
    }
}
