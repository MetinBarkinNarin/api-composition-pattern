package com.microservice.apigateway.application.service;

import com.microservice.apigateway.application.request.OrderCreateRequest;
import com.microservice.apigateway.application.request.OrderUpdateRequest;
import com.microservice.apigateway.domain.*;
import com.microservice.apigateway.infrastructure.client.CouponClient;
import com.microservice.apigateway.infrastructure.client.OrderClient;
import com.microservice.apigateway.infrastructure.client.PromotionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class OrderApiGateWayService {

    private final OrderClient orderClient;
    private final CouponClient couponClient;
    private final PromotionClient promotionClient;
    private final Map<Long, OrderDetail> orderDetailInMemoryCache = new HashMap<>();

    public OrderDetail aggregateOrderDetail(Long orderId) {
        OrderDetail cachedOrderDetail = orderDetailInMemoryCache.get(orderId);

        return Optional.ofNullable(cachedOrderDetail)
                .orElseGet(() -> CompletableFuture.supplyAsync(() -> orderClient.getOrderById(orderId))
                        .thenApply(retrievedOrder -> {
                            CompletableFuture<Coupon> couponFuture = CompletableFuture.supplyAsync(() -> couponClient.getCouponById(retrievedOrder.getCouponId()));
                            CompletableFuture<Promotion> promotionFuture = CompletableFuture.supplyAsync(() -> promotionClient.getPromotionById(retrievedOrder.getPromotionId()));
                            OrderDetail orderDetail = new OrderDetail(retrievedOrder, couponFuture.join(), promotionFuture.join());
                            orderDetailInMemoryCache.put(orderId, orderDetail);
                            return orderDetail;
                        }).join());

        /*
        Optional istersen query sonucu external cache de tutarak clientlara daha hızlı şekilde response dönülebilir.
        Any logic on orderDetail object
         */
    }

    public void createOrder(OrderCreateRequest orderCreateRequest) {
        /*
        Order create logics
         */
        orderDetailInMemoryCache.clear();
    }

    public void updateOrder(OrderUpdateRequest orderUpdateRequest) {
        /*
        Order update logics
         */
        orderDetailInMemoryCache.clear();
    }
}
