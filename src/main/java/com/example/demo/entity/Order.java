package com.example.demo.entity;


import com.example.demo.model.ShippingMethodEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cost;
    private String status;
    @Enumerated(EnumType.STRING)
    private ShippingMethodEnum shippingMethod;
    private Date day;
}
