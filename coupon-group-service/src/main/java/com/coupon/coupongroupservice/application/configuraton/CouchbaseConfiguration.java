package com.coupon.coupongroupservice.application.configuraton;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {
    @Override
    public String getConnectionString() {
        return "couchbase3";
    }

    @Override
    public String getUserName() {
        return "admin";
    }

    @Override
    public String getPassword() {
        return "admin123";
    }

    @Override
    public String getBucketName() {
        return "default";
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
