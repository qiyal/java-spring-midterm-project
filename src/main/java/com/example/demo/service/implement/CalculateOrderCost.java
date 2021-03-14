package com.example.demo.service.implement;

import com.example.demo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CalculateOrderCost {
    @Autowired
    private Cart cart;
    @Value("${my-delivery-cost}")
    private int deliveryCost;

    public CalculateOrderCost() {}

    public int calculateCost() {
        if (cart.getCost() < 5000) {
            return cart.getCost() + deliveryCost;
        }
        return cart.getCost();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(int deliveryCost) {
        this.deliveryCost = deliveryCost;
    }
}
