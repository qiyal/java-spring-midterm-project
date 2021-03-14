package com.example.demo.service.implement;

import com.example.demo.entity.MyOrder;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.IMyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyOrderService implements IMyOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void createOrder(MyOrder order) {
        orderRepository.save(order);
    }
}
