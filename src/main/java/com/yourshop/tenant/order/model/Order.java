package com.yourshop.tenant.order.model;

import com.yourshop.core.model.TenantBaseModel;
import com.yourshop.tenant.orderdetail.model.OrderDetail;

/**
 * @author G
 */
public class Order extends TenantBaseModel {
    private String id;
    private String vipId;
    private double totalPrice;
    private OrderDetail[] orderDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVipId() {
        return vipId;
    }

    public void setVipId(String vipId) {
        this.vipId = vipId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderDetail[] getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetail[] orderDetails) {
        this.orderDetails = orderDetails;
    }
}
