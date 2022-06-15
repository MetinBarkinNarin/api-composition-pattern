package com.promotion.promotionservice.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Promotion {

    private Long id;
    private Double discount;
    private Long usedOrderId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
}
