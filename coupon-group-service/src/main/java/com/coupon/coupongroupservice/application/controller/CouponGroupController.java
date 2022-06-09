package com.coupon.coupongroupservice.application.controller;


import com.coupon.coupongroupservice.application.service.CouponGroupService;
import com.coupon.coupongroupservice.domain.CouponGroupCreateRequest;
import com.coupon.coupongroupservice.domain.CouponGroupGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/coupon-groups")
@RequiredArgsConstructor
public class CouponGroupController {

    private final CouponGroupService couponGroupService;


    @PostMapping
    public ResponseEntity create(@RequestBody CouponGroupCreateRequest command) {
        String couponGroupId = couponGroupService.create(command);
        return ResponseEntity.created(URI.create("/coupon-groups/" + couponGroupId)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CouponGroupGetResponse> get(@PathVariable("id") String id) {
        CouponGroupGetResponse getCouponGroupResponse = couponGroupService.get(id);
        return new ResponseEntity<>(getCouponGroupResponse, OK);
    }


}
