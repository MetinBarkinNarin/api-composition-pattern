package com.order.orderservice.application.service;

import com.order.orderservice.application.repository.OrderRepository;
import com.order.orderservice.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public Order getCreatedOrder(Long orderId) {
        Order order = orderRepository.getById(orderId);
        log.info("Created order returned order service");
        return order;
    }
}
