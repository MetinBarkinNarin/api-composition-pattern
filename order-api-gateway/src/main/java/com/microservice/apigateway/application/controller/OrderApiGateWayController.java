package com.microservice.apigateway.application.controller;

import com.microservice.apigateway.application.request.OrderCreateRequest;
import com.microservice.apigateway.application.request.OrderUpdateRequest;
import com.microservice.apigateway.application.service.OrderApiGateWayService;
import com.microservice.apigateway.domain.OrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderApiGateWayController {

    private final OrderApiGateWayService orderApiGateWayService;

    @GetMapping("order-detail/orders/{orderId}")
    public ResponseEntity<OrderDetail> aggregateOrderDetail(@PathVariable("orderId") Long orderId) {
        OrderDetail orderDetail = orderApiGateWayService.aggregateOrderDetail(orderId);
        return ResponseEntity.ok(orderDetail);
    }

    @PostMapping("orders")
    public ResponseEntity<Void> createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        orderApiGateWayService.createOrder(orderCreateRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("orders/order")
    public ResponseEntity<Void> updateOrder(@RequestBody OrderUpdateRequest orderUpdateRequest) {
        orderApiGateWayService.updateOrder(orderUpdateRequest);
        return ResponseEntity.ok().build();
    }
}
