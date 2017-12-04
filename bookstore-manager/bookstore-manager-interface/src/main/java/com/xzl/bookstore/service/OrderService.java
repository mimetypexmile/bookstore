package com.xzl.bookstore.service;

import com.xzl.bookstore.pojo.po.Orders;

import java.util.List;

public interface OrderService {
    int saveOrder(Orders orders);

    int payOrder(List<Long> ids,Long uid);

    List<Orders> listOrders();
}
