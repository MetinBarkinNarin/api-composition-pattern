package com.coupon.couponservice.application.controller;

import com.coupon.couponservice.application.service.CouponService;
import com.coupon.couponservice.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping("/coupon-applicable/{couponId}")
    public ResponseEntity<Coupon> getById(@PathVariable("couponId") Long couponId) {
        Coupon coupon = couponService.getById(couponId);
        return ResponseEntity.ok(coupon);
    }
}
