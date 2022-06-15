package com.coupon.couponservice.application.repository;

import com.coupon.couponservice.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon getById(Long couponId);
}
