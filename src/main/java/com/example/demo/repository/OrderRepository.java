package com.example.demo.repository;

import com.example.demo.entity.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<MyOrder, Long> {
    List<MyOrder> getMyOrdersByStatusNotOrderByStatus(String status);
}
