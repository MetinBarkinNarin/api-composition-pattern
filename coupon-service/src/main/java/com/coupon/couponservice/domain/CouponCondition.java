package com.coupon.couponservice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CouponCondition {

    private Long userId;
    private Long categoryId;
    private Long brandId;
    private Long sellerId;
}
