package com.yourshop.login.dao.impl;

import com.yourshop.core.runtime.ds.BaseDao;
import com.yourshop.login.dao.TenantUserAuthDao;
import com.yourshop.login.model.UserAuth;
import org.springframework.stereotype.Repository;

/**
 * @author G
 */
@Repository
public class TenantUserAuthDaoImpl extends BaseDao implements TenantUserAuthDao {
    @Override
    public UserAuth get(UserAuth userAuth) {
        return this.getSqlSession().selectOne("com.yourshop.login.dao.TenantUserAuthDao.get", userAuth);
    }
}
