package com.coupon.coupongroupservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CouponGroup {

    private String id;
    private int usageLimit;
    private int currentUsageCount;
    private String createdBy;



}
