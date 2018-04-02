package com.yourshop.platform.init;

import com.yourshop.common.util.DataSourceUtil;
import com.yourshop.core.model.PageResult;
import com.yourshop.core.runtime.ds.DaoTemplateFactory;
import com.yourshop.core.runtime.ds.DaoTemplateHolder;
import com.yourshop.core.runtime.ds.DataSourceHolder;
import com.yourshop.platform.datasource.model.Datasource;
import com.yourshop.platform.datasource.service.DatasourceService;
import com.yourshop.platform.tenant.model.Tenant;
import com.yourshop.platform.tenant.service.TenantService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author G
 */
@Component
public class InitDataSource implements InitializingBean {

    @Autowired
    private TenantService tenantService;

    @Autowired
    private DatasourceService datasourceService;

    @Override
    public void afterPropertiesSet() throws Exception {
//        PageResult<Tenant> pageResult = tenantService.query(0, 10000);
//        List<Tenant> tenants = pageResult.getData();
//        if (tenants != null && tenants.size() > 0) {
//            for (Tenant tenant : tenants) {
//                String datasourceId = tenant.getDatasourceId();
//                if (DataSourceHolder.get(datasourceId) == null) {
//                    Datasource datasource = datasourceService.findById(datasourceId);
//                    DataSource dataSource = DataSourceUtil.createDefaultC3P0Datasource(datasource);
//                    DataSourceHolder.put(datasource.getId(), dataSource);
//                    DaoTemplateHolder.put(datasource.getId(), DaoTemplateFactory.buildDaoTemplate(dataSource));
//                }
//            }
//        }
    }
}
