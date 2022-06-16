package com.microservice.apigateway.domain;

public record OrderDetail(
        Order order,
        Coupon coupon,
        Promotion promotion
) {
}
