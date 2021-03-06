package com.coupon.couponservice.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Coupon {

    private Long id;
    private Long usedOrderId;
    private BigDecimal discount;
    private BigDecimal lowerLimit;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
}
