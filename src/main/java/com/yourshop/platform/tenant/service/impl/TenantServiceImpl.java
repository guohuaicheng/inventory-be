package com.yourshop.platform.tenant.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yourshop.core.model.PageResult;
import com.yourshop.platform.tenant.dao.TenantDao;
import com.yourshop.platform.tenant.model.Tenant;
import com.yourshop.platform.tenant.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author G
 */
@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantDao tenantDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Tenant tenant) {
        this.tenantDao.insert(tenant);
    }

    @Override
    public Tenant findTenantById(int id) {
        return this.tenantDao.getById(id);
    }

    @Override
    public Tenant findTenantByDomainUrl(String url) {
        return this.tenantDao.getByDomainUrl(url);
    }

    @Override
    public PageResult<Tenant> query(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Tenant> tenants = this.tenantDao.query();
        PageInfo<Tenant> pageInfo = new PageInfo<Tenant>(tenants);
        return new PageResult<Tenant>(pageInfo.getTotal(), tenants);
    }
}
