package com.example.demo.service.implement;

import com.example.demo.entity.MyOrder;
import com.example.demo.model.OrderStatusEnum;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<MyOrder> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<MyOrder> getOrdersById(Long userId) {
        return orderRepository.getMyOrdersByUserId(userId);
    }

    @Override
    public MyOrder createNew(MyOrder order) {
        order.setDay(new Date());
        MyOrder saveOrder = orderRepository.saveAndFlush(order);

        for (int i = 0; i < saveOrder.getOrderItems().size(); i++) {
                saveOrder.getOrderItems().get(i).setOrderId(saveOrder.getId());
        }

        return orderRepository.saveAndFlush(saveOrder);
    }

    @Override
    public MyOrder changeOrderStatus(Long orderId, OrderStatusEnum status) {
        MyOrder order = orderRepository.getOne(orderId);
        order.setStatus(status);
        return orderRepository.saveAndFlush(order);
    }
}
