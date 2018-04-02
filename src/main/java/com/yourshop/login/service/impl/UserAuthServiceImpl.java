package com.yourshop.login.service.impl;

import com.yourshop.common.util.TenantCache;
import com.yourshop.core.runtime.user.TenantContextUtil;
import com.yourshop.login.dao.PlatformUserAuthDao;
import com.yourshop.login.dao.TenantUserAuthDao;
import com.yourshop.login.model.UserAuth;
import com.yourshop.login.service.UserAuthService;
import com.yourshop.platform.tenant.model.Tenant;
import com.yourshop.platform.tenant.service.TenantService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author G
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private PlatformUserAuthDao platformUserAuthDao;
    @Autowired
    private TenantUserAuthDao tenantUserAuthDao;
    @Autowired
    private TenantService tenantService;

    @Override
    public UserAuth findUserAuth(UserAuth userAuth) {
        if (userAuth == null || StringUtils.isEmpty(userAuth.getUsername())) {
            return null;
        }
        //平台用户
        if (StringUtils.isEmpty(userAuth.getDomainUrl())) {
            return platformUserAuthDao.get(userAuth.getUsername());
        } else { //租户
            String url = userAuth.getDomainUrl();
            Tenant tenant = TenantCache.getTenantByDomainUrl(url);
            if (tenant == null) {
                tenant = this.tenantService.findTenantByDomainUrl(userAuth.getDomainUrl());
            }
            if (tenant == null) {
                return null;
            } else {
                TenantCache.cacheTenant(String.valueOf(tenant.getId()), tenant);
            }
            userAuth.setTenantId(tenant.getId());
            TenantContextUtil.setTenant(tenant);
            return tenantUserAuthDao.get(userAuth);
        }

    }
}
