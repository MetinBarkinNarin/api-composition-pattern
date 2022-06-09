package com.coupon.coupongroupservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class CouponGroupServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponGroupServiceApplication.class, args);
    }

}
