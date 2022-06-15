package com.order.orderservice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Long id;
    private String productName;
    private Long productId;
    private Integer productQuantity;
    private Double productPrice;
    private Long userId;
    private Long couponId;
    private Long promotionId;
}
