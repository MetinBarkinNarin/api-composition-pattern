package com.order.orderservice.application.controller;

import com.order.orderservice.application.service.OrderService;
import com.order.orderservice.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Order> getCreatedOrder(@RequestParam Long orderId) {
        Order order = orderService.getCreatedOrder(orderId);
        return ResponseEntity.ok(order);
    }
}
