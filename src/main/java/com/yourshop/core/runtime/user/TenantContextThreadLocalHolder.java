package com.yourshop.core.runtime.user;

import com.yourshop.platform.tenant.model.Tenant;

/**
 * @author G
 */
public class TenantContextThreadLocalHolder {

    private final static ThreadLocal<Tenant> threadLocal = new ThreadLocal<Tenant>();

    public static Tenant get() {
        return threadLocal.get();
    }

    public static void set(Tenant tenant) {
        threadLocal.set(tenant);
    }

    public static void remove() {
        threadLocal.remove();
    }
}
