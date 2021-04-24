package com.example.demo.entity;


import com.example.demo.model.OrderStatusEnum;
import com.example.demo.model.ShippingMethodEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class MyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    private Integer cost;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;
    @Enumerated(EnumType.STRING)
    private ShippingMethodEnum shippingMethod;
    private Date day;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "myOrder", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItem> orderItems;
}
