package com.example.demo.service;

import com.example.demo.entity.MyOrder;

import java.util.ArrayList;

public interface IMyOrderService {
    void createOrder(MyOrder order);
    void updateOrderStatus(MyOrder order, String newStatus, String adminLogin);
    ArrayList<MyOrder> getOrderByStatusNot(String status);
    ArrayList<MyOrder> getOrdersByLogin(String login);
}
