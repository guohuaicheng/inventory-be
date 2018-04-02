package com.yourshop.core.runtime.ds;

import com.yourshop.common.constants.IConstants;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author G
 */
public class DaoTemplateFactory {

    public static DaoTemplate buildDaoTemplate(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(getLocations(IConstants.MAPPER_RESOURCE_LOCATION));
        try {
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
            DaoTemplate daoTemplate = new DaoTemplate();
            daoTemplate.setJdbcTemplate(new JdbcTemplate(dataSource));
            daoTemplate.setSqlSessionFactory(sqlSessionFactory);
            return daoTemplate;
        } catch (Exception e) {
            return null;
        }
    }

    private static Resource[] getLocations(String locationPattern) {
        Resource[] locations = null;

        try {
            locations = (new PathMatchingResourcePatternResolver()).getResources(locationPattern);
        } catch (IOException var3) {
            var3.printStackTrace();
        }

        return locations;
    }
}
