package com.promotion.promotionservice.application.service;

import com.promotion.promotionservice.application.repository.PromotionRepository;
import com.promotion.promotionservice.domain.Promotion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PromotionService {

    private final PromotionRepository promotionRepository;

    public Promotion getById(Long promotionId) {
        Promotion promotion = promotionRepository.getById(promotionId);
        log.info("Get promotion from promotion-service");
        return promotion;
    }
}
