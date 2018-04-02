package com.yourshop.core.runtime.user;

import com.yourshop.login.model.UserInfoVO;
import com.yourshop.platform.user.model.User;

/**
 * @author G
 */
public class UserContextThreadLocalHolder {

    private final static ThreadLocal<UserInfoVO> threadLocal = new ThreadLocal<UserInfoVO>();

    public static UserInfoVO get() {
        return threadLocal.get();
    }

    public static void set(UserInfoVO user) {
        threadLocal.set(user);
    }

    public static void remove() {
        threadLocal.remove();
    }
}
