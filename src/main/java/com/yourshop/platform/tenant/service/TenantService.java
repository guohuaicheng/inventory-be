package com.yourshop.platform.tenant.service;

import com.yourshop.core.model.PageResult;
import com.yourshop.platform.tenant.model.Tenant;

/**
 * @author G
 */
public interface TenantService {
    /**
     * 保存租户信息
     * @param tenant
     */
    void save(Tenant tenant);

    /**
     * 根据租户ID获取租户信息
     * @param id
     * @return
     */
    Tenant findTenantById(int id);

    /**
     * 根据租户URL获取租户信息
     * @param url
     * @return
     */
    Tenant findTenantByDomainUrl(String url);

    /**
     * 获取所有租户信息
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageResult<Tenant> query(int pageIndex, int pageSize);
}
