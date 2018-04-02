package com.yourshop.platform.tenant.model;

import com.yourshop.core.model.PlatformBaseModel;

/**
 * @author G
 */
public class Tenant extends PlatformBaseModel {
    private String id;
    private String name;
    private String domainUrl;
    private String datasourceId;

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

    public String getDatasourceId() {
        return datasourceId;
    }

    public void setDatasourceId(String datasourceId) {
        this.datasourceId = datasourceId;
    }

    public String getDomainUrl() {
        return domainUrl;
    }

    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }
}
