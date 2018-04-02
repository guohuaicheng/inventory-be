package com.yourshop.core.model;

/**
 * @author G
 */
public abstract class TenantBaseModel extends PlatformBaseModel {
    private String tenantId;

    private int tenantIndex;

    public int getTenantIndex() {
        return tenantIndex;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
        this.tenantIndex = Integer.valueOf(tenantId) % 10;
    }
}
