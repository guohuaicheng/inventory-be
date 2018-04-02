package com.yourshop.common.util;

import com.yourshop.core.runtime.ds.DaoTemplate;
import com.yourshop.core.runtime.ds.DaoTemplateFactory;
import com.yourshop.platform.datasource.model.Datasource;
import com.yourshop.platform.datasource.service.DatasourceService;
import com.yourshop.platform.tenant.model.Tenant;
import com.yourshop.platform.tenant.service.TenantService;
import org.apache.commons.lang3.StringUtils;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author G
 */
//@Component
public class TenantCache {

//    @Autowired
//    private TenantService tenantService;

    private static Map<String, Tenant> tenantCache = new ConcurrentHashMap<String, Tenant>();
//    private static Map<String, Datasource> datasourceCache;
    private static Map<String, DaoTemplate> daoTemplateCache = new ConcurrentHashMap<String, DaoTemplate>();

    public static void cacheTenant(String id, Tenant tenant) {
        tenantCache.put(id, tenant);
    }

    public static Tenant getTenant(String id) {
        Tenant tenant = tenantCache.get(id);
        if (tenant == null) {
           TenantService tenantService = ContextUtil.getBean(TenantService.class);
           tenant = tenantService.findTenantById(Integer.parseInt(id));
           tenantCache.put(id, tenant);
        }
        return tenant;
    }

    public static Tenant getTenantByDomainUrl(String domainUrl) {
        for (Tenant tenant : tenantCache.values()) {
            if(StringUtils.equals(domainUrl, tenant.getDomainUrl())) {
                return tenant;
            }
        }
        return null;
    }

//    public static void cacheDatasource(String id, Datasource datasource) {
//        if (datasourceCache == null) {
//            datasourceCache = new HashMap<String, Datasource>();
//        }
//        datasourceCache.put(id, datasource);
//    }
//
//    public static Datasource getDatasource(String id) {
//        if (datasourceCache == null) {
//            return null;
//        }
//        return datasourceCache.get(id);
//    }

    public static void cacheDaoTemplate(String id, DaoTemplate daoTemplate) {
        daoTemplateCache.put(id, daoTemplate);
    }

    public static DaoTemplate getDaoTemplate(String id) {
        DaoTemplate daoTemplate = daoTemplateCache.get(id);
        if(daoTemplate == null) {
            DatasourceService datasourceService = ContextUtil.getBean(DatasourceService.class);
            Datasource datasource = datasourceService.findById(id);
            if(datasource!= null) {
                DataSource dataSource = DataSourceUtil.createDefaultC3P0Datasource(datasource);
                daoTemplate = DaoTemplateFactory.buildDaoTemplate(dataSource);
                cacheDaoTemplate(id, daoTemplate);
            }
        }
        return daoTemplate;
    }
}
