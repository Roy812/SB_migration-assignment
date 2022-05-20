package com.example.demo.service;

import com.example.demo.model.OrderItem;
import com.example.demo.model.OrderTest;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void createOrder(OrderTest orderTest) {
        try {
//            orderTest.setItems(items);
            orderRepository.save(orderTest);
        } catch (Exception e) {
            throw new IllegalStateException("Order is incomplete");
        }
    }

    public void updateOrder(List<OrderItem> orderList, Long orderId) {
        OrderTest order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order not found"));
        order.setItems(orderList);
        orderRepository.save(order);
    }

    public List<OrderTest> getAllOrders() {
        List<OrderTest> orderList = orderRepository.findAll();
        if (!orderList.isEmpty()) {
            return orderList;
        }
        throw new IllegalStateException("List of orders not found");
    }
}
