package com.yourshop.platform.tenant.controller;

import com.yourshop.core.model.PageResult;
import com.yourshop.platform.tenant.model.Tenant;
import com.yourshop.platform.tenant.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author G
 */
@RestController
@RequestMapping("/platform/tenants")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @RequestMapping(method = RequestMethod.POST)
    public Tenant save(@RequestBody Tenant tenant) {
        this.tenantService.save(tenant);

        return tenant;
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageResult<Tenant> query(@RequestParam(defaultValue = "1") int pageIndex, @RequestParam(defaultValue = "10") int pageSize) {
        return this.tenantService.query(pageIndex, pageSize);
    }

}
