package com.example.demo.controller;

import com.example.demo.model.OrderItem;
import com.example.demo.model.OrderTest;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/migration")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    public void createOrder(@RequestBody OrderTest order) {
        orderService.createOrder(order);
    }

    @PatchMapping("{id}")
    public void updateOrder(@RequestBody List<OrderItem> orderList, @PathVariable("id") Long orderId) {
        orderService.updateOrder(orderList, orderId);
    }

    @GetMapping()
    public List<OrderTest> getOrders() {
        return orderService.getAllOrders();
    }
}
