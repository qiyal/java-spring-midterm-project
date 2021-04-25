package com.example.demo.event;

import com.example.demo.entity.MyOrder;
import com.example.demo.model.OrderStatusEnum;
import org.springframework.context.ApplicationEvent;

public class ChangeOrderStatus extends ApplicationEvent {
    private OrderStatusEnum oldStatus;
    private MyOrder myOrder;

    public ChangeOrderStatus(Object source, OrderStatusEnum oldStatus, MyOrder myOrder) {
        super(source);
        this.oldStatus = oldStatus;
        this.myOrder = myOrder;
    }

    public OrderStatusEnum getOldStatus() {
        return oldStatus;
    }

    public MyOrder getMyOrder() {
        return myOrder;
    }
}
