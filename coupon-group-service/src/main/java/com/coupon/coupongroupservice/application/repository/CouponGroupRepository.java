package com.coupon.coupongroupservice.application.repository;

import com.coupon.coupongroupservice.domain.CouponGroup;

public interface CouponGroupRepository {


    CouponGroup getById(String id);

    void save(CouponGroup couponGroup);


}
