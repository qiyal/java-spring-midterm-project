package com.example.demo.controller;

import com.example.demo.entity.MyOrder;
import com.example.demo.service.implement.MyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class MyOrderController {
    @Autowired
    private MyOrderService myOrderService;

    public void saveOrder(MyOrder order) {
        myOrderService.createOrder(order);
    }

    public void updateOrderStatus(MyOrder order, String newStatus, String adminLogin) {
        myOrderService.updateOrderStatus(order, newStatus, adminLogin);
    }

    public ArrayList<MyOrder> getByStatusNot(String status) {
        return myOrderService.getOrderByStatusNot(status);
    }
}
