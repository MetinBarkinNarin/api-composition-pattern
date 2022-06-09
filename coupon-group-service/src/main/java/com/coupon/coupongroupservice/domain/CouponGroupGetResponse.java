package com.coupon.coupongroupservice.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CouponGroupGetResponse {

    private String id;
    private int usageLimit;
    private int currentUsageCount;
    private String createdBy;

}
