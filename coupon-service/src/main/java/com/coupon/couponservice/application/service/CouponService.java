package com.coupon.couponservice.application.service;

import com.coupon.couponservice.application.repository.CouponRepository;
import com.coupon.couponservice.domain.Coupon;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    public Coupon getById(Long couponId) {

        Coupon coupon = couponRepository.getById(couponId);

        log.info("Get Coupon from Coupon-service");
        return coupon;
    }
}
