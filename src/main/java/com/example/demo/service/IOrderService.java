package com.example.demo.service;

import com.example.demo.entity.MyOrder;
import com.example.demo.model.OrderStatusEnum;

import java.util.List;

public interface IOrderService {
    List<MyOrder> getAll();
    List<MyOrder> getOrdersById(Long userId);
    MyOrder createNew(MyOrder order);
    MyOrder changeOrderStatus(Long orderId, OrderStatusEnum status);
}
