package com.promotion.promotionservice.application.repository;

import com.promotion.promotionservice.domain.Promotion;

public interface PromotionRepository {
    Promotion getById(Long promotionId);
}
