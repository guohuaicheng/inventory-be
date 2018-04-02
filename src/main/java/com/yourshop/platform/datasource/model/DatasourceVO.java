package com.yourshop.platform.datasource.model;

/**
 * @author G
 */
public class DatasourceVO extends Datasource {
    private int tenantCount;

    public int getTenantCount() {
        return tenantCount;
    }

    public void setTenantCount(int tenantCount) {
        this.tenantCount = tenantCount;
    }
}
