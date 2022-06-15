package com.order.orderservice.application.repository;


import com.order.orderservice.domain.Order;

public interface OrderRepository {
    Order getById(Long orderId);
}
