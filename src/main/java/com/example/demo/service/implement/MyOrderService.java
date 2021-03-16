package com.example.demo.service.implement;

import com.example.demo.entity.MyOrder;
import com.example.demo.event.ChangeOrderStatus;
import com.example.demo.event.ClientAddNewFavorite;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.IMyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyOrderService implements IMyOrderService, ApplicationEventPublisherAware {
    @Autowired
    private OrderRepository orderRepository;
    private ApplicationEventPublisher eventPublisher;


    @Override
    public void createOrder(MyOrder order) {
        orderRepository.save(order);
    }

    @Override
    public void updateOrderStatus(MyOrder order, String newStatus, String adminLogin) {
        String oldStatus = order.getStatus();
        order.setStatus(newStatus);
        orderRepository.save(order);
        eventPublisher.publishEvent(new ChangeOrderStatus(this, oldStatus, order, adminLogin));
    }

    @Override
    public ArrayList<MyOrder> getOrderByStatusNot(String status) {
        return (ArrayList<MyOrder>) orderRepository.getMyOrdersByStatusNotOrderByStatus(status);
    }

    @Override
    public ArrayList<MyOrder> getOrdersByLogin(String login) {
        return (ArrayList<MyOrder>) orderRepository.getMyOrdersByClientLogin(login);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
