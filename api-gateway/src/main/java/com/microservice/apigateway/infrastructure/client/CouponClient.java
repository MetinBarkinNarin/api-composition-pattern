package com.microservice.apigateway.infrastructure.client;

import com.microservice.apigateway.domain.Coupon;
import org.springframework.stereotype.Component;

@Component
public class CouponClient {

    public Coupon getCouponById(Long couponId) {
        return new Coupon();
    }
}
