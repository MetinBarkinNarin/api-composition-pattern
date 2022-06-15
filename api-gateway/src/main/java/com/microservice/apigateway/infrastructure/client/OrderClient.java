package com.microservice.apigateway.infrastructure.client;

import com.microservice.apigateway.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderClient {

    public Order getOrderById(Long orderId) {
        return new Order();
    }
}
