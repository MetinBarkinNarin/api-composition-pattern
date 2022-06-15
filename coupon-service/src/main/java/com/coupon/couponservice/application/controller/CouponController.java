package com.coupon.couponservice.application.controller;

import com.coupon.couponservice.application.service.CouponService;
import com.coupon.couponservice.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CouponController {


    private final CouponService couponService;

    @PostMapping("/coupon-applicable")
    ResponseEntity<Coupon> getById(@RequestParam Long couponId) {
        Coupon coupon = couponService.getById(couponId);
        return ResponseEntity.ok(coupon);
    }

}
