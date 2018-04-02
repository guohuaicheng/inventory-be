package com.yourshop.tenant.order.controller;

import com.yourshop.tenant.order.model.Order;
import com.yourshop.tenant.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author G
 */
@RestController
@RequestMapping("/tenant/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public Order createOrder(@RequestBody Order order) {
        return this.orderService.createOrder(order);
    }
}
