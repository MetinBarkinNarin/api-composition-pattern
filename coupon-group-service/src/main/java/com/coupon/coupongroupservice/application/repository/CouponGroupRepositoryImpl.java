package com.coupon.coupongroupservice.application.repository;

import com.couchbase.client.core.error.DocumentExistsException;
import com.couchbase.client.core.error.DocumentNotFoundException;
import com.couchbase.client.java.ReactiveCollection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.kv.InsertOptions;
import com.coupon.coupongroupservice.domain.CouponGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import static java.time.Duration.ofMillis;


@Repository
@RequiredArgsConstructor
public class CouponGroupRepositoryImpl implements CouponGroupRepository {

    private final ReactiveCollection couponGroupReactiveCollection;

    @Override
    public CouponGroup getById(String id) {


        GetResult couponGroupResult = couponGroupReactiveCollection.get(id)
                .onErrorResume(ex -> {
                    if (ex instanceof DocumentNotFoundException) {
                        return Mono.empty();
                    }
                    return couponGroupReactiveCollection.getAnyReplica(id)
                            .onErrorResume(secondEx -> Mono.empty());
                }).block();

        assert couponGroupResult != null;
        return couponGroupResult.contentAs(CouponGroup.class);

    }


    public void save(CouponGroup couponGroup) {

        couponGroupReactiveCollection.insert(couponGroup.getId(),
                        couponGroup,
                        InsertOptions.insertOptions().timeout(ofMillis(500)))
                .doOnError(ex -> {
                    if (ex instanceof DocumentExistsException) {
                        System.out.println("Document already exists when inserting with documentId: {}, Exception: " + couponGroup + ex);
                    } else {
                        System.out.println("Error when inserting documentId: {}, document: {}, Exception: " + couponGroup + couponGroup + ex);
                    }
                })
                .retryWhen(Retry.fixedDelay(3, ofMillis(10))
                        .filter(t -> !(t instanceof DocumentExistsException)))
                .block();
    }


}
