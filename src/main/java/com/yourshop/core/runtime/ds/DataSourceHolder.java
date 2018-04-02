package com.yourshop.core.runtime.ds;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author G
 */
public class DataSourceHolder {
    private static Map<String, DataSource> map = new ConcurrentHashMap<String, DataSource>();

    public static void put(String key, DataSource dataSource) {
        map.put(key, dataSource);
    }

    public static DataSource get(String key) {
        return map.get(key);
    }

    public static void clear() {
        map.clear();
    }
}
