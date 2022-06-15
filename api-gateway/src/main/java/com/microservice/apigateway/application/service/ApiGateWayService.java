package com.microservice.apigateway.application.service;

import com.microservice.apigateway.domain.Coupon;
import com.microservice.apigateway.domain.Order;
import com.microservice.apigateway.domain.OrderDetail;
import com.microservice.apigateway.domain.Promotion;
import com.microservice.apigateway.infrastructure.client.CouponClient;
import com.microservice.apigateway.infrastructure.client.OrderClient;
import com.microservice.apigateway.infrastructure.client.PromotionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiGateWayService {

    private final OrderClient orderClient;
    private final CouponClient couponClient;
    private final PromotionClient promotionClient;

    public OrderDetail aggregateOrderDetail(Long orderId) {
        Order order = orderClient.getOrderById(orderId);
        Coupon coupon = couponClient.getCouponById(order.getCouponId());
        Promotion promotion = promotionClient.getPromotionById(order.getPromotionId());
        /*
        Any logic on orderDetail object
         */
        return new OrderDetail(order, coupon, promotion);
    }
}
