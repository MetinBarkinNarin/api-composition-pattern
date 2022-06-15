package com.microservice.apigateway.application.controller;

import com.microservice.apigateway.application.service.ApiGateWayService;
import com.microservice.apigateway.domain.OrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiGateWayController {

    private final ApiGateWayService apiGateWayService;

    @GetMapping("order-detail/orders/{orderId}")
    public ResponseEntity<OrderDetail> aggregateOrderDetail(@PathVariable("orderId") Long orderId) {
        OrderDetail orderDetail = apiGateWayService.aggregateOrderDetail(orderId);
        return ResponseEntity.ok(orderDetail);
    }
}
