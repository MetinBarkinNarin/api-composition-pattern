package com.coupon.couponservice.application.repository;

import com.coupon.couponservice.domain.Coupon;

public interface CouponRepository {

    Coupon getById(Long couponId);
}
