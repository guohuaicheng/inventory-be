package com.yourshop.core.runtime.ds;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author G
 */
public class DaoTemplateHolder {
    private static Map<String, DaoTemplate> map = new ConcurrentHashMap<String, DaoTemplate>();

    public static void put(String key, DaoTemplate daoTemplate) {
        map.put(key, daoTemplate);
    }

    public static DaoTemplate get(String key) {
        return map.get(key);
    }

    public static void clear() {
        map.clear();
    }
}
