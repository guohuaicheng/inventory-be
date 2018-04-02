package com.yourshop.platform.tenant.dao;

import com.yourshop.platform.annotation.MybatisRepository;
import com.yourshop.platform.tenant.model.Tenant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author G
 */
@MybatisRepository
@Repository
public interface TenantDao {
    /**
     * 插入租户信息
     * @param tenant
     */
    void insert(Tenant tenant);

    /**
     * 根据id获取租户信息
     * @param id
     * @return
     */
    Tenant getById(@Param("id") int id);

    /**
     * 根据租户URL获取用户
     * @param domainUrl
     * @return
     */
    Tenant getByDomainUrl(@Param("domainUrl") String domainUrl);

    /**
     * 获取所有租户信息
     * @return
     */
    List<Tenant> query();
}
