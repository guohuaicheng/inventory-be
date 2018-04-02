package com.yourshop.login.dao;

import com.yourshop.login.model.UserAuth;

/**
 * @author G
 */
public interface TenantUserAuthDao {
    /**
     * 根据用户名和租户获取租户用户信息
     * @param userAuth
     * @return
     */
    UserAuth get(UserAuth userAuth);
}
