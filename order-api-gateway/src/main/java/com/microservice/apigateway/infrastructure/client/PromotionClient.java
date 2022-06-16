package com.microservice.apigateway.infrastructure.client;

import com.microservice.apigateway.domain.Promotion;
import org.springframework.stereotype.Component;

@Component
public class PromotionClient {

    public Promotion getPromotionById(Long promotionId) {
        return new Promotion();
    }
}
