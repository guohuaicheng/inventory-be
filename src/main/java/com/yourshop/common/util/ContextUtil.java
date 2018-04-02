package com.yourshop.common.util;

import com.yourshop.core.runtime.user.UserContextThreadLocalHolder;
import com.yourshop.login.model.UserInfoVO;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Locale;

/**
 * @author G
 */
public class ContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static UserInfoVO getCurrentUser() {
        return UserContextThreadLocalHolder.get();
    }

//    public static void setCurrentUser(UserInfoVO user) {
//        UserContextThreadLocalHolder.set(user);
//    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext1) throws BeansException {
        applicationContext = applicationContext1;
    }

    public static <T> T getBean(String beanId, Class<T> clazz) throws BeansException {
        return applicationContext.getBean(beanId, clazz);
    }

    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return applicationContext.getBean(clazz);
    }

    public static String getMessage(String code, Object[] params, String defaultDesc, Locale local) {
        return applicationContext.getMessage(code, params, defaultDesc, local);
    }

//    public static TenantCache getCacheUtil() {
//        return applicationContext.getBean(TenantCache.class);
//    }
}
