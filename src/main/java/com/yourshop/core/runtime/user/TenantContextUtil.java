package com.yourshop.core.runtime.user;

import com.yourshop.common.util.TenantCache;
import com.yourshop.core.runtime.ds.DaoTemplate;
import com.yourshop.platform.tenant.model.Tenant;

/**
 * @author G
 */
public class TenantContextUtil {

    public static Tenant getTenant() {
        return TenantContextThreadLocalHolder.get();
    }

    public static void setTenant(Tenant tenant) {
        TenantContextThreadLocalHolder.set(tenant);
    }

    public static DaoTemplate getDaoTemplate() {
        Tenant tenant = getTenant();
        if (tenant == null) {
            return null;
        }
//        TenantCache tenantCache = ContextUtil.getCacheUtil();
//        String datasourceId = tenant.getDatasourceId();
//        DaoTemplate daoTemplate = TenantCache.getDaoTemplate(datasourceId);
//        if (daoTemplate != null) {
//            return daoTemplate;
//        }
//        Datasource datasource = tenantCache.getDatasource(datasourceId);
//        if (datasource == null) {
//            DatasourceService datasourceService = ContextUtil.getBean(DatasourceService.class);
//            datasource = datasourceService.findById(tenant.getDatasourceId());
//        }
//        if (datasource == null) {
//            return null;
//        }
//        DataSource dataSource = DataSourceUtil.createDefaultC3P0Datasource(datasource);
//        daoTemplate = DaoTemplateFactory.buildDaoTemplate(dataSource);
//        tenantCache.cacheDatasource(datasourceId, datasource);
//        tenantCache.cacheDaoTemplate(datasourceId, daoTemplate);
        return TenantCache.getDaoTemplate(tenant.getDatasourceId());
//        return daoTemplate;
    }

}
