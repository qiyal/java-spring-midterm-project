package com.example.demo.handler;

import com.example.demo.event.ChangeOrderStatus;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ChangeOrderStatusHandler implements ApplicationListener<ChangeOrderStatus> {

    @Override
    public void onApplicationEvent(ChangeOrderStatus changeOrderStatus) {
        System.out.println("ChangeOrderStatusHandler is triggered");
        System.out.println("Old status: " + changeOrderStatus.getOldStatus());
        System.out.println("New status: " + changeOrderStatus.getMyOrder().getStatus());
        System.out.println("Admin: " + changeOrderStatus.getAdmin());
    }
}
