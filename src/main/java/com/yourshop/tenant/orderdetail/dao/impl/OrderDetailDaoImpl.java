package com.yourshop.tenant.orderdetail.dao.impl;

import com.yourshop.core.runtime.ds.BaseDao;
import com.yourshop.tenant.orderdetail.dao.OrderDetailDao;
import com.yourshop.tenant.orderdetail.model.OrderDetail;
import org.springframework.stereotype.Repository;

/**
 * @author G
 */
@Repository
public class OrderDetailDaoImpl extends BaseDao implements OrderDetailDao {
    @Override
    public void insert(OrderDetail orderDetail) {
        this.getSqlSession().insert("com.yourshop.tenant.orderdetail.dao.OrderDetailDao", orderDetail);
    }
}
