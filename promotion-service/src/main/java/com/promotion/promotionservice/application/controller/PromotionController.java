package com.promotion.promotionservice.application.controller;

import com.promotion.promotionservice.application.service.PromotionService;
import com.promotion.promotionservice.domain.Promotion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionService promotionService;

    @GetMapping("/promotion/{id}")
    public ResponseEntity<Promotion> getById(@RequestParam Long promotionId) {

        Promotion promotion = promotionService.getById(promotionId);
        return ResponseEntity.ok(promotion);
    }

}
