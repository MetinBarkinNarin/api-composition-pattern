package com.coupon.coupongroupservice.application.service;

import com.coupon.coupongroupservice.application.repository.CouponGroupRepository;
import com.coupon.coupongroupservice.domain.CouponGroup;
import com.coupon.coupongroupservice.domain.CouponGroupCreateRequest;
import com.coupon.coupongroupservice.domain.CouponGroupGetResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponGroupService {

    private final CouponGroupRepository couponGroupRepository;

    public String create(CouponGroupCreateRequest command) {

        CouponGroup couponGroup = CouponGroup.builder()
                .id(UUID.randomUUID().toString())
                .usageLimit(command.getUsageLimit())
                .createdBy(command.getCreatedBy())
                .build();
        couponGroupRepository.save(couponGroup);
        return couponGroup.getId();
    }

    public CouponGroupGetResponse get(String id) {
        CouponGroup couponGroup = couponGroupRepository.getById(id);
        return CouponGroupGetResponse.builder()
                .usageLimit(couponGroup.getUsageLimit())
                .currentUsageCount(couponGroup.getCurrentUsageCount())
                .createdBy(couponGroup.getCreatedBy())
                .id(couponGroup.getId())
                .build();

    }

}
