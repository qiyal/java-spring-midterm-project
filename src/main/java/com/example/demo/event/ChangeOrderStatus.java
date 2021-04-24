package com.example.demo.event;

import com.example.demo.entity.MyOrder;
import org.springframework.context.ApplicationEvent;

public class ChangeOrderStatus extends ApplicationEvent {
    private String oldStatus;
    private MyOrder myOrder;
    private String admin;

    public ChangeOrderStatus(Object source, String oldStatus, MyOrder myOrder, String admin) {
        super(source);
        this.oldStatus = oldStatus;
        this.myOrder = myOrder;
        this.admin = admin;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public MyOrder getMyOrder() {
        return myOrder;
    }

    public String getAdmin() {
        return admin;
    }
}
