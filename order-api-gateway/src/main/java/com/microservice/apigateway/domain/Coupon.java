package com.microservice.apigateway.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Coupon {

    private String id;
    private Long usedOrderId;
    private BigDecimal discount;
    private BigDecimal lowerLimit;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
}
