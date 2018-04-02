package com.yourshop.tenant.orderdetail.service.impl;

import com.yourshop.common.util.IDGenerator;
import com.yourshop.tenant.orderdetail.dao.OrderDetailDao;
import com.yourshop.tenant.orderdetail.model.OrderDetail;
import com.yourshop.tenant.orderdetail.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author G
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;
    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        if(orderDetail == null){
            throw new IllegalArgumentException();
        }
        orderDetail.setId(IDGenerator.generateUUID());
        this.orderDetailDao.insert(orderDetail);
        return orderDetail;
    }
}
