package com.coupon.coupongroupservice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CouponGroupCreateRequest {

    private int usageLimit;
    private String createdBy;
}
