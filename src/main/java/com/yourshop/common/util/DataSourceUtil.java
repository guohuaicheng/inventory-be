package com.yourshop.common.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yourshop.platform.datasource.model.Datasource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author G
 */
public class DataSourceUtil {

    public static DataSource createDefaultC3P0Datasource(Datasource datasource){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(datasource.getDriver());
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(datasource.getUrl());
        dataSource.setUser(datasource.getUser());
        String password = datasource.getPassword();
        dataSource.setPassword(password);
        dataSource.setAutoCommitOnClose(false);
        dataSource.setCheckoutTimeout(datasource.getCheckoutTimeout());
        dataSource.setInitialPoolSize(datasource.getInitialPoolSize());
        dataSource.setMinPoolSize(datasource.getMinPoolSize());
        dataSource.setMaxPoolSize(datasource.getMaxPoolSize());
        dataSource.setMaxIdleTime(datasource.getMaxIdleTime());
        dataSource.setAcquireIncrement(datasource.getAcquireIncrement());
        dataSource.setMaxIdleTimeExcessConnections(1800);
        return dataSource;
    }
}
