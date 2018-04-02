package com.yourshop.platform.datasource.model;

import com.yourshop.core.model.PlatformBaseModel;

/**
 * @author G
 */
public class Datasource extends PlatformBaseModel {
    private String id;
    private String name;
    private String driver;
    private String url;
    private String user;
    private String password;
    /**
     * maxPoolSize
     */
    private Integer maxPoolSize = 15;
    /**
     * minPoolSize
     */
    private Integer minPoolSize = 3;
    /**
     * checkoutTimeout
     */
    private Integer checkoutTimeout = 1000;
    /**
     * initialPoolSize
     */
    private Integer initialPoolSize = 3;
    /**
     * maxIdleTime
     */
    private Integer maxIdleTime = 100;
    /**
     * acquireIncrement
     */
    private Integer acquireIncrement = 3;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Integer getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(Integer maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public Integer getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(Integer minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public Integer getCheckoutTimeout() {
        return checkoutTimeout;
    }

    public void setCheckoutTimeout(Integer checkoutTimeout) {
        this.checkoutTimeout = checkoutTimeout;
    }

    public Integer getInitialPoolSize() {
        return initialPoolSize;
    }

    public void setInitialPoolSize(Integer initialPoolSize) {
        this.initialPoolSize = initialPoolSize;
    }

    public Integer getMaxIdleTime() {
        return maxIdleTime;
    }

    public void setMaxIdleTime(Integer maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }

    public Integer getAcquireIncrement() {
        return acquireIncrement;
    }

    public void setAcquireIncrement(Integer acquireIncrement) {
        this.acquireIncrement = acquireIncrement;
    }

}
