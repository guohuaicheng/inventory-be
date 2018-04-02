package com.yourshop.tenant.order.dao.impl;

import com.yourshop.core.runtime.ds.BaseDao;
import com.yourshop.tenant.order.dao.OrderDao;
import com.yourshop.tenant.order.model.Order;
import org.springframework.stereotype.Repository;

/**
 * @author G
 */
@Repository
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int insert(Order order) {
        return this.getSqlSession().insert("com.yourshop.tenant.order.dao.OrderDao.insert", order);
    }
}
