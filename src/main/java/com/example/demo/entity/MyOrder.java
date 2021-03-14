package com.example.demo.entity;


import javax.persistence.*;

@Entity
public class MyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cost;
    private String clientLogin;
    private String status;

    public MyOrder() {}

    public MyOrder(Integer cost, String clientLogin, String status) {
        this.cost = cost;
        this.clientLogin = clientLogin;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cost=" + cost +
                '}';
    }
}
