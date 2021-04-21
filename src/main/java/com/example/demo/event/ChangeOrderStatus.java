package com.example.demo.event;

import com.example.demo.entity.Order;
import org.springframework.context.ApplicationEvent;

public class ChangeOrderStatus extends ApplicationEvent {
    private String oldStatus;
    private Order order;
    private String admin;

    public ChangeOrderStatus(Object source, String oldStatus, Order order, String admin) {
        super(source);
        this.oldStatus = oldStatus;
        this.order = order;
        this.admin = admin;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public Order getMyOrder() {
        return order;
    }

    public String getAdmin() {
        return admin;
    }
}
