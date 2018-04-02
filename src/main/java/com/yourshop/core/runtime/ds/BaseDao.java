package com.yourshop.core.runtime.ds;

import com.yourshop.core.runtime.user.TenantContextUtil;
import com.yourshop.platform.tenant.model.Tenant;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author G
 */
public abstract class BaseDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    protected SqlSession getSqlSession() {
        Tenant tenant = TenantContextUtil.getTenant();
        if (tenant == null) {
            return this.sqlSessionFactory.openSession();
        }
        DaoTemplate daoTemplate = TenantContextUtil.getDaoTemplate();
        return daoTemplate.getSqlSessionFactory().openSession();
    }

    protected JdbcTemplate getJdbcTemplate() {
        return null;
    }
}