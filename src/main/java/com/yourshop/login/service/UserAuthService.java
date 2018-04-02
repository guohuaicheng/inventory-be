package com.yourshop.login.service;

import com.yourshop.login.model.UserAuth;

/**
 * @author G
 */
public interface UserAuthService {
    /** 获取登录用户信息
     * @param userAuth
     * @return
     */
    UserAuth findUserAuth(UserAuth userAuth);
}
