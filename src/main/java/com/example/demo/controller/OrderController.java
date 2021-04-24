package com.example.demo.controller;

import com.example.demo.entity.MyOrder;
import com.example.demo.model.OrderStatusEnum;
import com.example.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    // GET - 2
    @GetMapping("")
    public ResponseEntity<?> getOrdersByUserId(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(iOrderService.getOrdersById(userId));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok(iOrderService.getAll());
    }

    // POST
    @PostMapping("/create")
    public ResponseEntity<?> createNewOrder(@RequestBody MyOrder order) {
        return ResponseEntity.ok(iOrderService.createNew(order));
    }

    //PATCH
    @PatchMapping("/{id}/change-order-status")
    public ResponseEntity<?> changeOrderStatus(@PathVariable("id") Long id, @RequestBody OrderStatusEnum status) {
        return ResponseEntity.ok(iOrderService.changeOrderStatus(id, status));
    }
}
